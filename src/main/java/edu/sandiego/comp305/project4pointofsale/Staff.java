package edu.sandiego.comp305.project4pointofsale;

public abstract class Staff {

    private int id;

    private String name;

    public abstract boolean login();

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
