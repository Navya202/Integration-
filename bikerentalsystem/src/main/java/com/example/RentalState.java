package com.example;

import java.time.LocalDateTime;

public interface RentalState {
    void handleState(Rental rental);
    void makeReservation(Rental rental, Bike bike, Customer customer, Staff staff);
    void processExtensionRequest(Rental rental, LocalDateTime newEndTime);
    void processEarlyReturn(Rental rental, LocalDateTime newEndTime);
}



