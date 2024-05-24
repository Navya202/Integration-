package com.example;
import java.time.LocalDateTime;

public class ExtendedState implements RentalState {

    @Override
    public void handleState(Rental rental) {
        System.out.println("Rental is currently extended.");
    }

    @Override
    public void makeReservation(Rental rental, Bike bike, Customer customer, Staff staff) {
        System.out.println("Rental is already extended. Cannot make a new reservation.");
    }

    @Override
    public void processExtensionRequest(Rental rental, LocalDateTime newEndTime) {
        rental.setEndTime(newEndTime);
        rental.setRentalDuration(rental.calculateDuration());
        rental.setRentalCharges(rental.calculateCharges());
        System.out.println("Rental extended again. New end time: " + newEndTime);
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

