package main;
import models.Title;
import models.TitleOmdb;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import exception.DurationConversionErrorException;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner lectureScanner = new Scanner(System.in);
        List<Title> movies = new ArrayList<>();

        
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
                
        while (true) {
            System.out.println("Enter movie name (or 'exit' to finish) : ");
            var  search = lectureScanner.nextLine();

            if (search.equalsIgnoreCase("exit")){
                break;
            }
            //URLEncoder class to encode strings into a format that can be safely transmitted in URLs
            //(for example, replacing spaces with %20 or +).
            String encoded = URLEncoder.encode(search, "UTF-8");
            String address = "http://www.omdbapi.com/?t="+encoded+"&apikey=abbc99ff&";
            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TitleOmdb myTitleOmdb = gson.fromJson(json,TitleOmdb.class);
                System.out.println(myTitleOmdb);

                Title myTitle = new Title(myTitleOmdb);
                System.out.println("Title: " + myTitle);

                movies.add(myTitle);
            }catch (NumberFormatException e){
                System.out.println("an error occurred.: ");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){
                System.out.println("URL error, verify the address.");
            }catch(DurationConversionErrorException e){
                System.out.println(e.getMessage());
            }finally{
                System.out.println("Program has ended. Thanks for running me!");
            }
            System.out.println(movies);

            FileWriter filmDataJson = new FileWriter("movies.json");
            filmDataJson.write(gson.toJson(movies));
            filmDataJson.close();
            System.out.println("All movie details saved to movies.json!");

        }
	}
}