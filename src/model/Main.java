package model;

import obj.Movie;
import obj.SearchEngine;

import java.util.ArrayList;





public class Main {

    private static final SearchEngine se = new SearchEngine();

    //Main method
    public static void main(String[] args) {
        se.setMovies(createMovies(10));
        int x = 1;
        try {
            while (x != 0) {
                se.search();
                x=se.printResults();
            }
        }catch (NullPointerException e){
            System.out.println("Oops, there were an error.");
            e.printStackTrace();
        }
    }

    /**
     * Generate an array of movies
     * @param amount how much movies do you need
     * @return Arraylist<Movie>
     */

    private static ArrayList<Movie> createMovies(int amount){
        ArrayList<Movie> movies = new ArrayList<>();
        for(int i=0;i<amount;i++){
            movies.add(new Movie());
            movies.get(i).setId(i);
        }
        movies.add(null);
        return movies;
    }


}
