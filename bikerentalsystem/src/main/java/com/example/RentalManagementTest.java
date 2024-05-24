package com.example;

import java.time.LocalDateTime;

public class RentalManagementTest {

    public static void main(String[] args) {
        // Create test objects
        Bike bike = new Bike(1, "Mountain Bike", "BrandA", "ModelX", true);
        Customer customer = new Customer(1, "John Doe", "johndoe@example.com", "1234567890");
        Staff staff = new Staff(1, "Alice Smith", "alice.smith@example.com");
        LocalDateTime startTime = LocalDateTime.of(2024, 5, 18, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2024, 5, 20, 10, 0);
        double depositAmount = 100.0;

        // Create a Rental object
        Rental rental = new Rental(1, startTime, endTime, depositAmount);

        // Initial state should be ReservedState
        System.out.println("Initial State: " + rental.getState().getClass().getSimpleName());
        rental.getState().handleState(rental);

        // Make a reservation
        rental.makeReservation(bike, customer, staff);
        System.out.println("State after reservation: " + rental.getState().getClass().getSimpleName());
        rental.getState().handleState(rental);

        // Process extension request
        LocalDateTime newEndTime = LocalDateTime.of(2024, 5, 22, 10, 0);
        rental.processExtensionRequest(newEndTime);
        System.out.println("State after extension request: " + rental.getState().getClass().getSimpleName());
        rental.getState().handleState(rental);

        // Track usage
        rental.trackUsage();

        // Handle damage report
        rental.handleDamageReport("Scratch on the frame");

        // Generate analytics
        rental.generateAnalytics();

        // Process early return
        LocalDateTime earlyReturnTime = LocalDateTime.of(2024, 5, 19, 10, 0);
        rental.processEarlyReturn(earlyReturnTime);
        System.out.println("State after early return: " + rental.getState().getClass().getSimpleName());
        rental.getState().handleState(rental);

        // Final state should be ReturnedState
        rental.getState().handleState(rental);
    }
}


