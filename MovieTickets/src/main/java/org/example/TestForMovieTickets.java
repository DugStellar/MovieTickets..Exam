package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForMovieTickets {

    @Test
    public void calculateTotalTicketPrice_CalculatedSuccessfully() {
        MovieTickets movieTickets = new MovieTickets();
        int numberOfTickets = 5;
        double ticketPrice = 10.0;
        double expectedTotalPrice = 50.0;

        double actualTotalPrice = movieTickets.calculateTotalTicketPrice(numberOfTickets, ticketPrice);

        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @Test
    public void validateData_ValidDataReturnsTrue() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData validData = new MovieTicketData("Movie Name", 5, 10.0);

        boolean isValid = movieTickets.validateData(validData);

        assertTrue(isValid);
    }

    @Test
    public void validateData_InvalidMovieNameReturnsFalse() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData invalidData = new MovieTicketData("", 5, 10.0);

        boolean isValid = movieTickets.validateData(invalidData);

        assertFalse(isValid);
    }

    @Test
    public void validateData_InvalidNumberOfTicketsReturnsFalse() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData invalidData = new MovieTicketData("Movie Name", 0, 10.0);

        boolean isValid = movieTickets.validateData(invalidData);

        assertFalse(isValid);
    }

    @Test
    public void validateData_InvalidTicketPriceReturnsFalse() {
        MovieTickets movieTickets = new MovieTickets();
        MovieTicketData invalidData = new MovieTicketData("Movie Name", 5, -10.0);

        boolean isValid = movieTickets.validateData(invalidData);

        assertFalse(isValid);
    }
}
