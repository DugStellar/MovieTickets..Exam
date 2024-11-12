package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MovieTicketSales extends JFrame implements MovieTickets {

    private JComboBox<String> movieComboBox;
    private JTextField numTicketsField, ticketPriceField;
    private JTextArea reportTextArea;
    private JButton processButton;

    public MovieTicketSales() {
        setTitle("Movie Ticket Sales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel movieLabel = new JLabel("Movie:");
        movieComboBox = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        JLabel numTicketsLabel = new JLabel("Number of Tickets:");
        numTicketsField = new JTextField(10);
        JLabel ticketPriceLabel = new JLabel("Ticket Price:");
        ticketPriceField = new JTextField(10);
        processButton = new JButton("Process");

        inputPanel.add(movieLabel);
        inputPanel.add(movieComboBox);
        inputPanel.add(numTicketsLabel);
        inputPanel.add(numTicketsField);
        inputPanel.add(ticketPriceLabel);
        inputPanel.add(ticketPriceField);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(processButton);

        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false); // Make report text area non-editable
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processTicketSales();
            }
        });

        // Create and add menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processTicketSales());
        toolsMenu.add(processItem);

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearFields());
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void processTicketSales() {
        String movieName = (String) movieComboBox.getSelectedItem();
        int numTickets;
        double ticketPrice;

        try {
            numTickets = Integer.parseInt(numTicketsField.getText());
            ticketPrice = Double.parseDouble(ticketPriceField.getText());

            // Validate data (can be implemented in a separate method)
            if (!validateData(new MovieTicketData(movieName, numTickets, ticketPrice))) {
                throw new IllegalArgumentException("Invalid data entered. Please check number of tickets and ticket price.");
            }

            MovieTicketData movieTicketData = new MovieTicketData(movieName, numTickets, ticketPrice);
            double totalTicketPrice = calculateTotalTicketPrice(numTickets, ticketPrice);
            double vatAmount = totalTicketPrice * 0.14; // Assuming 14% VAT
            double totalAmount = totalTicketPrice + vatAmount;

            reportTextArea.setText("MOVIE NAME: " + movieName + "\n" +
                    "MOVIE TICKET PRICE: R " + ticketPrice + "\n" +
                    "NUMBER OF TICKETS: " + numTickets + "\n" +
                    "TOTAL TICKET PRICE: R " + totalTicketPrice + "\n" +
                    "VAT AMOUNT: R " + vatAmount + "\n" +
                    "TOTAL AMOUNT: R " + totalAmount);

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    }