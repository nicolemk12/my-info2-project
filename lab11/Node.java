package lab11;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
    private HashMap<String, Integer> nachbarn;
    private String name;
    private int distanz;

    public Node(HashMap<String,Integer> nachbarn,int distanz,String name) {
        this.nachbarn = nachbarn;
        this.distanz = distanz;
        this.name = name;
    }

    public int getDistanz() {
        return distanz;
    }

    public void setDistanz(int distanz) {
        this.distanz = distanz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getNachbarn() {
        return nachbarn;
    }

    public void setNachbarn(HashMap<String, Integer> nachbarn) {
        this.nachbarn = nachbarn;
    }
}
