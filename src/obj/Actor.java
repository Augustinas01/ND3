package obj;

import enm.ActorNames;
import enm.ActorSurNames;

import java.util.ArrayList;

public class Actor {

    private int age;
    private ActorNames name;
    private ActorSurNames surname;
    private ArrayList<Movie> starred = new ArrayList<>();


    /**
     *
     * @param name Name of Actor
     * @param surname Surname of Actor
     * @param age Age of Actor
     */

    public Actor(ActorNames name, ActorSurNames surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    /**
     *
     * @return A full name of Actor(Name + Surname)
     */

    public String getFullName(){
        return this.name + " " + this.surname;
    }
}
