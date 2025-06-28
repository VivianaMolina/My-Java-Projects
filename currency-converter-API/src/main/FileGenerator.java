package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FileGenerator {
    private static final String LOG_FILE = "conversions.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public record ConversionRecord(
    String timestamp,
    double amount,
    String fromCurrency,
    String toCurrency,
    double result
    ) {}

    public void saveJson(double amount, String from, String to, double result) throws IOException{
        List<ConversionRecord> conversions = loadExistingConversions();
        
        ConversionRecord newConversion = new ConversionRecord(
            LocalDateTime.now().format(DATE_FORMATTER),
            amount,
            from.toUpperCase(),
            to.toUpperCase(),
            result
        );
        
        conversions.add(newConversion);
        saveConversions(conversions);
    }

    private List<ConversionRecord> loadExistingConversions() throws IOException {
        if(!Files.exists(Path.of(LOG_FILE))) {
            return new ArrayList<>();
        }
        
        String json = Files.readString(Path.of(LOG_FILE));
        return GSON.fromJson(json, new TypeToken<List<ConversionRecord>>(){}.getType());
    }

    private void saveConversions(List<ConversionRecord> conversions) throws IOException {
        String json = GSON.toJson(conversions);
        Files.writeString(
            Path.of(LOG_FILE),
            json,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}
