package edu.sandiego.comp305.project4pointofsale;

public abstract class Staff {

    private int id;

    private String name;

    private final String password;

    public Staff(final int id, final String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public boolean login(final String password){
        return this.password.equals(password);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
