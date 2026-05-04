package edu.sandiego.comp305.project4pointofsale;

public class KitchenTicket {

    private int ticketId;

    private Status status;

    private Order ticketOrder;

    private KitchenTicket(){
        this.ticketId = 0;
        this.status = Status.IN_PROCESS;
        this.ticketOrder = new Order();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Status getStatus() {
        return status;
    }

    public Order getTicketOrder() {
        return ticketOrder;
    }


}
