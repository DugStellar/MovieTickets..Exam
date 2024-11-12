package org.example;
public class MovieTicketData {
    private final String movieName;
    private final int numTickets;
    private final double ticketPrice;

    public MovieTicketData(String movieName, int numTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numTickets = numTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
