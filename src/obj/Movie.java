package obj;

import enm.MovieGenre;

import java.util.ArrayList;

public class Movie {
    private int id, rating, commentId;
    private String title;
    private MovieGenre genre;
    private ArrayList<String> cast;
    private ArrayList<Comment> comment;


    public Movie(String title)  {
        if(title==null){
            throw new NullPointerException();
        }
        this.title = title;
        this.commentId = 0;
    }

    //region Getters
    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }
    //endregion

    //region Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }
    //endregion

    public void addComment(String cmnt) {
        this.comment.add(new Comment(cmnt, this.commentId));
        this.commentId+=1;
    }

    public void printMovie(){
        System.out.printf("Title: %s \n" +
                "Genre: %s%n",this.title,this.genre);
    }

}
