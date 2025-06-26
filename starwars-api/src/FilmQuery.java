import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;

public class FilmQuery {
    public Film searchFilm(int filmNumber) {
        //URI address = URI.create("https://swapi.py4e.com/api/films/" + filmNumber);
        URI address = URI.create("https://swapi.py4e.com/api/films/" + filmNumber + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        
        try {
            HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Film.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esta película");
        }
    }
}
