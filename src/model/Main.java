package model;

import obj.Comment;
import obj.Movie;
import enm.MovieGenre;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;




public class Main {

    public static final String[] movieNamePart1 = {"The ", "Comeback of ","Tale of ", "Yes, it's a ","Revenge of "};
    public static final String[] movieNamePart2 = {"super ", "mighty ", "black ", "pink ","old ","new ","incredible "};
    public static final String[] movieNamePart3 = {"rat","rider","king","hero","panther","family","age"};



    private static ArrayList<Movie> movies = new ArrayList<>();
    private static ThreadLocalRandom r = ThreadLocalRandom.current();

    public static void main(String[] args) {
        createMovies(10,movies);
        movies.get(r.nextInt(10)).printMovie();


    }

    private static void createMovies(int amount, ArrayList<Movie> movie){
        for(int i=0;i<amount;i++){
            movie.add(new Movie(generateName()));
            movie.get(i).setId(i);
            movie.get(i).setGenre(MovieGenre.values()[r.nextInt(MovieGenre.values().length)]);
            movie.get(i).setRating(r.nextInt(10));
            //movie.get(i).addComment(new Comment());
        }
    }
    private static String generateName(){
        return movieNamePart1[r.nextInt(movieNamePart1.length)] + movieNamePart2[r.nextInt(movieNamePart2.length)] + movieNamePart3[r.nextInt(movieNamePart3.length)];
    }
}
