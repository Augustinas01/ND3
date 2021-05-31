package helpers;

import model.Actor;
import model.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {

    private final Scanner sc = new Scanner(System.in);
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Integer> searchResults;
    private int type;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    /**
     * Finds out by what filter user wants to search his films and starts search()
     *
     * If user a monke, sets type to 404
     */
    public void search(){
        System.out.println("Search movie by (N)ame, (G)enre, (A)ctor?");
        switch (sc.nextLine().toLowerCase()) {
            case "n" -> {
                System.out.println("What movie title are we looking for?");
                System.out.print("Title: ");
                this.type = 1;
            }
            case "g" -> {
                System.out.println("What genre are you interested?");
                System.out.print("Genre: ");
                this.type = 2;
            }
            case "a" -> {
                System.out.println("Which actor are we searching for?");
                System.out.print("Actor: ");
                this.type = 3;
            }
            default -> {
                System.out.println("I cannot understand you :(");
                System.out.println("Please try again.");
                this.type = 404;
            }
        }
        assign();
    }

    /**
     * Filters movies to searchResult Array.
     * If 404 sets searchResults to null.
     */

    private void assign(){
        if(this.type == 404){ this.searchResults = null;}
        this.searchResults = new ArrayList<>();
        String search = sc.next().toLowerCase().trim();
        this.searchResults.add(type);
        sc.nextLine();
        switch (type) {
            case 1 -> {
                for (Movie movie : movies) {
                    if (movie != null && movie.getTitle().contains(search)) {
                        this.searchResults.add(movie.getId());
                    }
                }
            }
            case 2 -> {
                for (Movie movie : movies) {
                    if (movie != null && movie.getGenre().toString().toLowerCase().equals(search)) {
                        this.searchResults.add(movie.getId());
                    }
                }
            }
            case 3 -> {
                for (Movie movie : movies) {
                    if (movie != null) {
                        for (Actor act:movie.getCast()){
                            if(act.getFullName().toLowerCase().contains(search)){
                                this.searchResults.add(movie.getId());
                                break;
                            }
                        }
                    }
                }
            }
            default -> this.searchResults = null;
        }
    }

    /**
     * Prints searchResults and asks user to choose a movie
     * @return 0 exits program
     */

    public int printResults(){
        if (this.searchResults != null) {
            if((this.searchResults.size()-1) == 0){
                System.out.println("Found 0 movies. :(");
                return 1;
            }
            System.out.println("Found " + (this.searchResults.size()-1) + " movies:");
            for (int movieId : this.searchResults) {
                if(this.searchResults.indexOf(movieId)!=0) {
                    System.out.println("(" + movieId + ")" + "  " + this.movies.get(movieId).getTitle() + ".");
                }
            }
            System.out.println("For more info please select movie number");
            this.movies.get(this.sc.nextInt()).printMovie();
            this.sc.nextLine();
//                System.out.println("Select another one? Y/N");
//                if(this.sc.nextLine().trim().equalsIgnoreCase("y")){
//                    printResults();
//                }
            System.out.println("Search another one? Y/N");
            if(sc.nextLine().trim().equalsIgnoreCase("n")){
                return 0;
            }
            searchResults.clear();
            return 1;
        }
        return 0;
    }

}
