package com.example;

public class Staff {
    private int staffId;
    private String name;
    private String role;

    public Staff(int staffId, String name, String role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    public void manageRental(Rental rental) {
        // Logic to manage rental
        System.out.println("Managing rental ID: " + rental.getRentalId());
    }

    public void assistCustomer(Customer customer) {
        // Logic to assist customer
        System.out.println("Assisting customer ID: " + customer.getCustomerId());
    }

    // Getters and Setters
}

