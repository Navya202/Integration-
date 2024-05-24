package com.example;

public class Recommendation {
    private int recommendationId;
    private String recommendationText;
    private Customer customer;

    public Recommendation(int recommendationId, String recommendationText, Customer customer) {
        this.recommendationId = recommendationId;
        this.recommendationText = recommendationText;
        this.customer = customer;
    }

    public void provideRecommendation() {
        // Logic to provide rental recommendation
        System.out.println("Providing recommendation to customer ID: " + customer.getCustomerId());
    }

    // Getters and Setters
}

