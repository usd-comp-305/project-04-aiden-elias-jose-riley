package edu.sandiego.comp305.project4pointofsale;

public class KitchenTicket {

    private int ticketId;

    private Status status;

    private Order ticketOrder;

    public KitchenTicket(final int ticketId, final Order order){
        this.ticketId = ticketId;
        this.status = Status.ORDERED;
        this.ticketOrder = order;
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

    public void setStatus(final Status status){
        this.status = status;
    }


}
