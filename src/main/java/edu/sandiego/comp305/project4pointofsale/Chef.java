package edu.sandiego.comp305.project4pointofsale;

public class Chef extends Staff{
    public Chef(final int id, final String name, final String password){
        super(id, name, password);
    }

    @Override
    public StaffRole getRole() {
        return StaffRole.CHEF;
    }

    public void createOrder(){}

    public void sendOrder(){}

}
