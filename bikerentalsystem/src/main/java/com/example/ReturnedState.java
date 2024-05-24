package com.example;

import java.time.LocalDateTime;

public class ReturnedState implements RentalState {

    @Override
    public void handleState(Rental rental) {
        System.out.println("Rental is currently returned.");
    }

    @Override
    public void makeReservation(Rental rental, Bike bike, Customer customer, Staff staff) {
        System.out.println("Rental has already been returned. Cannot make a new reservation.");
    }

    @Override
    public void processExtensionRequest(Rental rental, LocalDateTime newEndTime) {
        System.out.println("Cannot extend a rental that has been returned.");
    }

    @Override
    public void processEarlyReturn(Rental rental, LocalDateTime newEndTime) {
        System.out.println("Rental has already been returned.");
    }
}

