package org.example;
public interface MovieTickets {
    double calculateTotalTicketPrice(int numTickets, double ticketPrice);
    boolean validateData(MovieTicketData movieTicketData);
}
