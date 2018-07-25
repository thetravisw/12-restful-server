package Models;

public class Whisky {

    private static int ID_COUNT = 470;

    public int id;
    public String name;
    public double rating;

    public Whisky (String name, double rating) {
        this.id = ID_COUNT++;
        this.name = name;
        this.rating = rating;
    }

    public String toString() {
        return this.name + " has earned " + this.rating + "out of 10";
    }

}



