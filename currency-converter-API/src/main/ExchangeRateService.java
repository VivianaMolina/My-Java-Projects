package main;

import com.google.gson.Gson;

import models.ExchangeRateResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ExchangeRateService {
    private static final String API_KEY = "YOUR KEY";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static final Gson GSON = new Gson();
    private ExchangeRateResponse cachedResponse;

    public ExchangeRateResponse fetchLatestRates() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        if(response.statusCode() != 200) {
            throw new Exception("API request failed with status: " + response.statusCode());
        }

        ExchangeRateResponse apiResponse = GSON.fromJson(response.body(), ExchangeRateResponse.class);
        
        if(!apiResponse.isSuccess()) {
            throw new Exception("API error: " + apiResponse.documentation());
        }
        
        this.cachedResponse = apiResponse;
        return apiResponse;
    }

    public double convert(double amount, String from, String to) throws Exception {
        if(cachedResponse == null) {
            fetchLatestRates();
        }

        Map<String, Double> rates = cachedResponse.conversion_rates();
        Double fromRate = rates.get(from.toUpperCase());
        Double toRate = rates.get(to.toUpperCase());
        
        if(fromRate == null || toRate == null) {
            throw new Exception("Invalid currency code");
        }
        
        return (amount / fromRate) * toRate;
    }

    public String getLastUpdateTime() {
        return cachedResponse != null ? cachedResponse.time_last_update_utc() : null;
    }
}