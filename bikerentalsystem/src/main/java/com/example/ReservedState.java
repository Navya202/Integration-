package com.example;

import java.time.LocalDateTime;

public class ReservedState implements RentalState {

    @Override
    public void handleState(Rental rental) {
        System.out.println("Rental is currently reserved.");
    }

    @Override
    public void makeReservation(Rental rental, Bike bike, Customer customer, Staff staff) {
        System.out.println("Rental is already reserved.");
    }

    @Override
    public void processExtensionRequest(Rental rental, LocalDateTime newEndTime) {
        System.out.println("Cannot extend a reservation that hasn't started yet.");
    }

    @Override
    public void processEarlyReturn(Rental rental, LocalDateTime newEndTime) {
        System.out.println("Cannot return a rental that hasn't started yet.");
    }
}

