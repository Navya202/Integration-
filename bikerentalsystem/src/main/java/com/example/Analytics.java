package com.example;

public class Analytics {
    private int analyticsId;
    private String rentalTrend;
    private double revenue;

    public Analytics(String rentalTrend, double revenue) {
        this.rentalTrend = rentalTrend;
        this.revenue = revenue;
    }

    public void generateAnalytics() {
        // Logic to generate analytics
        System.out.println("Generating analytics report: " + rentalTrend);
    }

    // Getter
    public String getRentalTrend() {
        return rentalTrend;
    }
}