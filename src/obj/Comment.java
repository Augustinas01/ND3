package obj;

import java.util.concurrent.ThreadLocalRandom;

public class Comment {

    public static final String[] commentPart1 = {"Hello,", "First of all,","Okay,","I just want to say, that"};
    public static final String[] commentPart2= {"super", "mighty", "fantastic","new","incredible", "non-sense","old"};


    private int id, rating;
    private String text;
    private static final ThreadLocalRandom r = ThreadLocalRandom.current();

    //region Getters
    public String getText() {
        return text;
    }
    //endregion
    public Comment() {

    }

    public Comment(int id) {
        this.id = id;
        this.rating = r.nextInt(1,5);
        this.text = generateText();
    }
    private String generateText(){
        return commentPart1[r.nextInt(commentPart1.length)] + " it's " + commentPart2[r.nextInt(commentPart2.length)] + "." + "I rate it for " + this.rating;
    }
    public void printComment(){
        System.out.println(this.text);
    }
    public int getComRating(){
        return this.rating;
    }
}
