package com.example;

import java.time.LocalDateTime;

public class Payment {
    private int paymentId;
    private double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;

    public Payment(int paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDateTime.now();
    }

    public void processPayment() {
        // Logic to process payment
        System.out.println("Processing payment ID: " + paymentId);
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}