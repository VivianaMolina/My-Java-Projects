import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileGenerator {
    public void saveJson(Film film) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(film.title()+".json");
        writer.write(gson.toJson((film)));
        writer.close();
    }

}
