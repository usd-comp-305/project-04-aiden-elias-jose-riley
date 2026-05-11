package edu.sandiego.comp305.project4pointofsale;

public abstract class Staff {

    private final int id;

    private final String name;

    private final String password;

    public Staff(final int id, final String name, final String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public boolean correctPassowrd(final String password){
        return this.password.equals(password);
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public abstract StaffRole getRole();

}
