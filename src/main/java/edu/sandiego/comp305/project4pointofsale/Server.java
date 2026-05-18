package edu.sandiego.comp305.project4pointofsale;

public class Server extends Staff{
    public Server(final int id, final String name, final String password){
        super(id, name, password);
    }

    @Override
    public StaffRole getRole()   {
        return StaffRole.SERVER;
    }

    public Order createOrder(final POSSystem pos){
        return null;
    }

    public void addItemToOrder(final Order order, final MenuItem item){

    }

    public void submitOrder(final POSSystem pos, final Order order){

    }

    public double calculateOrderTotal(final Order order){
        return 0.0;
    }


}
