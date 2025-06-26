import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerLecture = new Scanner(System.in);
        FilmQuery getFilm = new FilmQuery();
        System.out.println("Type the Film number you want to inquire");
        try {
            var filmNumber =  Integer.valueOf(scannerLecture.nextLine());
            Film film = getFilm.searchFilm(filmNumber);
            System.out.println(film);    
            FileGenerator generator = new FileGenerator();
            generator.saveJson(film);      
        }catch(NumberFormatException e){
            System.out.println("Number not found "+e.getMessage());

        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Application Ended.");
        }
        
    }
}
