package com.example;

public class LoyaltyProgram {
    private int loyaltyProgramId;
    private String programName;
    private int points;
    private Customer customer;

    public LoyaltyProgram(int loyaltyProgramId, String programName, int points, Customer customer) {
        this.loyaltyProgramId = loyaltyProgramId;
        this.programName = programName;
        this.points = points;
        this.customer = customer;
    }

    public void manageLoyaltyProgram() {
        // Logic to manage loyalty program
        System.out.println("Managing loyalty program: " + programName);
    }

    public void addPoints(int points) {
        this.points += points;
        System.out.println("Added " + points + " points to customer ID: " + customer.getCustomerId());
    }

    public void redeemPoints(int points) {
        if (this.points >= points) {
            this.points -= points;
            System.out.println("Redeemed " + points + " points from customer ID: " + customer.getCustomerId());
        } else {
            System.out.println("Insufficient points to redeem");
        }
    }

    // Getter
    public int getPoints() {
        return points;
    }
}