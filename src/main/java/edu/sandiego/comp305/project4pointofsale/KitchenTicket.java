package edu.sandiego.comp305.project4pointofsale;

public class KitchenTicket {

    private int ticketId;

    private Status status;

    private Order ticketOrder;

    private KitchenTicket(){
        this.ticketId = 0;
        this.status = null;
        this.ticketOrder = null;
    }

}
