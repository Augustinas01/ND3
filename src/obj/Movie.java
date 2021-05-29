package obj;

import enm.ActorNames;
import enm.ActorSurNames;
import enm.MovieGenre;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Movie  {
    public static final String[] movieNamePart1 = {"The ", "Comeback of ","Tale of ", "Yes, it's a ","Revenge of "};
    public static final String[] movieNamePart2 = {"super ", "mighty ", "black ", "pink ","old ","new ","incredible "};
    public static final String[] movieNamePart3 = {"rat","rider","king","hero","panther","family","age"};


    private int id, rating, commentId;
    private String title;
    private MovieGenre genre;
    private ArrayList<Actor> cast;
    private final ArrayList<Comment> comment = new ArrayList<>();
    private static final ThreadLocalRandom r = ThreadLocalRandom.current();


    //region Constructors
    public Movie() {
        this.title = generateMovieName();
        this.commentId = 0;
        this.genre = MovieGenre.values()[r.nextInt(MovieGenre.values().length)];
        for(int i=0;i<r.nextInt(1,15);i++){
            addComment();
        }
        addNullComment();
        generateCast(r.nextInt(2,20));
    }

    public Movie(String title)  {
        if(title==null){
            throw new NullPointerException();
        }
        this.title = title;
        this.commentId = 0;
        generateCast(r.nextInt(3,20));
    }
    //endregion

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

    public ArrayList<Actor> getCast() {
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

    public void setCast(ArrayList<Actor> cast) {
        this.cast = cast;
    }
    //endregion

    public void addComment() {
        this.comment.add(new Comment(this.commentId));
        this.commentId+=1;
    }
    public void addNullComment() {
        this.comment.add(null);
        this.commentId+=1;
    }

    public void printMovie(){
        System.out.printf("Title: %s \nGenre: %s \nRating: %.1f \nCast: %s \nComments: %s",
                this.title,this.genre,calculateRating(), castToString(),commentsToString() );
    }
    public float calculateRating(){
        int averageMovieRating = 0;
        for(Comment cmt: this.comment){
            if(cmt != null) {
                averageMovieRating += cmt.getComRating();
            }
        }
        return (float) averageMovieRating/(this.comment.size()-1);
    }

    //region Generators

    private static String generateMovieName(){
        return movieNamePart1[r.nextInt(movieNamePart1.length)] + movieNamePart2[r.nextInt(movieNamePart2.length)] + movieNamePart3[r.nextInt(movieNamePart3.length)];
    }

    private void generateCast(int amount){
        this.cast = new ArrayList<>();
        for(int i=0;i<amount;i++){
            this.cast.add(new Actor(generateActorName(),generateActorSurName(), r.nextInt(6,105)));
        }
    }

    private static ActorNames generateActorName(){
        return ActorNames.values()[r.nextInt(ActorNames.values().length)];
    }
    private static ActorSurNames generateActorSurName(){
        return ActorSurNames.values()[r.nextInt(ActorSurNames.values().length)];
    }
    //endregion

    //region toString
    private String castToString(){
        StringBuilder str = new StringBuilder();
        for (Actor act:this.cast){
            str.append(act.getFullName());
            if(this.cast.indexOf(act) == this.cast.size()-1){
                str.append(".");
            }else{
                str.append(", ");
            }
            if(this.cast.indexOf(act)%4==0 && this.cast.indexOf(act)!=0){
                str.append("\n      ");
            }
        }
        return str.toString();
    }

    private String commentsToString(){
        StringBuilder str = new StringBuilder();
        for (Comment cmt:this.comment){
            if(cmt != null) {
                if (this.comment.indexOf(cmt) != this.comment.size() - 2) {
                    str.append(cmt.getText()).append("\n          ");
                } else {
                    str.append(cmt.getText()).append("\n");
                }
            }
//            else{
//                System.out.println("-----------------------------");
//                System.out.println("There are null comments!!!");
//                System.out.println("-----------------------------");
//            }
        }
        return str.toString();
    }


    //endregion

}
