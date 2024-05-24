package com.example;

import java.time.LocalDateTime;

public class ActiveState implements RentalState {

    @Override
    public void handleState(Rental rental) {
        System.out.println("Rental is currently active.");
    }

    @Override
    public void makeReservation(Rental rental, Bike bike, Customer customer, Staff staff) {
        System.out.println("Rental is already active. Cannot make a new reservation.");
    }

    @Override
    public void processExtensionRequest(Rental rental, LocalDateTime newEndTime) {
        rental.setEndTime(newEndTime);
        rental.setRentalDuration(rental.calculateDuration());
        rental.setRentalCharges(rental.calculateCharges());
        System.out.println("Rental extended. New end time: " + newEndTime);
    }

    @Override
    public void processEarlyReturn(Rental rental, LocalDateTime newEndTime) {
        rental.setEndTime(newEndTime);
        rental.setRentalDuration(rental.calculateDuration());
        rental.setRentalCharges(rental.calculateCharges());
        rental.setState(new ReturnedState());
        System.out.println("Rental returned early. End time: " + newEndTime);
    }
}

