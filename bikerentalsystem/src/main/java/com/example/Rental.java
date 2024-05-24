package com.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    private static int counter = 0;
    private int rentalId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double charges;
    private List<Bike> bikes;
    private User user;
    private double depositAmount;
    private Customer customer;
    private Staff staff;
    private Payment payment;
    private List<DamageReport> damageReports;
    private Analytics analytics;
    private RentalState state;
    private long rentalDuration;
    private double rentalCharges;

    public Rental(User user, Bike bike, int duration) {
        this.rentalId = ++counter;
        this.bikes = new ArrayList<>();
        this.bikes.add(bike);
        this.user = user;
        this.startTime = LocalDateTime.now();
        this.endTime = startTime.plusHours(duration);
        this.charges = calculateCharges();
    }

    public Rental(int rentalId, LocalDateTime startTime, LocalDateTime endTime, double depositAmount) {
        this.rentalId = rentalId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depositAmount = depositAmount;
        this.bikes = new ArrayList<>();
        this.damageReports = new ArrayList<>();
        this.state = new ReservedState();
        this.charges = calculateCharges();
    }

    // Other constructors, getters, and setters...

    public long calculateDuration() {
        return ChronoUnit.HOURS.between(startTime, endTime);
    }

    public double calculateCharges() {
        long hours = ChronoUnit.HOURS.between(startTime, endTime);
        return hours * 10.0; // Assume $10 per hour
    }

    public void makeReservation(Bike bike, Customer customer, Staff staff) {
        state.makeReservation(this, bike, customer, staff);
        if (state instanceof ReservedState) {
            this.bikes.add(bike);
            this.customer = customer;
            this.staff = staff;
            this.state = new ActiveState();
        }
    }

    public void processExtensionRequest(LocalDateTime newEndTime) {
        state.processExtensionRequest(this, newEndTime);
        if (state instanceof ActiveState) {
            this.state = new ExtendedState();
        }
    }

    public void processEarlyReturn(LocalDateTime newEndTime) {
        state.processEarlyReturn(this, newEndTime);
    }

    public void trackUsage() {
        // Logic to track usage
        System.out.println("Tracking usage for rental ID: " + rentalId);
    }

    public void manageDeposit() {
        // Logic to handle deposit
        System.out.println("Managing deposit for rental ID: " + rentalId);
    }

    public void handleDamageReport(String description) {
        this.damageReports.add(new DamageReport(description, LocalDateTime.now()));
    }

    public void generateAnalytics() {
        this.analytics = new Analytics("Trend Analysis", 1000.0);
        analytics.generateAnalytics();
    }

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append("Invoice: \n");
        invoice.append("Rental ID: ").append(rentalId).append("\n");
        for (Bike bike : bikes) {
            invoice.append("Bike: ").append(bike).append("\n");
        }
        invoice.append("User: ").append(user.getUsername()).append("\n");
        invoice.append("Start Time: ").append(startTime).append("\n");
        invoice.append("End Time: ").append(endTime).append("\n");
        invoice.append("Charges: $").append(charges);
        return invoice.toString();
    }

    // Getters and Setters
    public int getRentalId() {
        return rentalId;
    }

    public void setState(RentalState state) {
        this.state = state;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<DamageReport> getDamageReports() {
        return damageReports;
    }

    public void setDamageReports(List<DamageReport> damageReports) {
        this.damageReports = damageReports;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }

    public RentalState getState() {
        return state;
    }

    public long getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(long rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalCharges() {
        return rentalCharges;
    }

    public void setRentalCharges(double rentalCharges) {
        this.rentalCharges = rentalCharges;
    }

    public boolean isOngoing() {
        return endTime.isAfter(LocalDateTime.now());
    }

    public void endRental() {
        this.endTime = LocalDateTime.now();
        this.rentalDuration = ChronoUnit.HOURS.between(startTime, endTime);
        this.rentalCharges = calculateCharges();
        // Additional logic to handle rental ending
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", charges=" + charges +
                ", bikes=" + bikes +
                ", user=" + user.getUsername() +
                ", depositAmount=" + depositAmount +
                ", customer=" + customer +
                ", staff=" + staff +
                ", payment=" + payment +
                ", damageReports=" + damageReports +
                ", analytics=" + analytics +
                ", state=" + state +
                '}';
    }
}
