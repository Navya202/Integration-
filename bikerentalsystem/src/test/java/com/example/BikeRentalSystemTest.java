package com.example;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BikeRentalSystemTest {
    
    private Account account;
    private Bike bike;
    private Customer customer;
    private Staff staff;
    private Rental rental;
    private LoyaltyProgram loyaltyProgram;

    @Before
    public void setUp() {
        account = new Account(1, "username", "password");
        bike = new Bike(1, "Mountain", "Giant", "Talon 1", true);
        customer = new Customer(1, "John Doe", "john@example.com", "1234567890");
        staff = new Staff(1, "Jane Smith", "Manager");
        rental = new Rental(1, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 100.0);
        loyaltyProgram = new LoyaltyProgram(1, "Gold", 100, customer);
    }

    @Test
    public void testChangePassword() {
        account.changePassword("newpassword");
        assertEquals("newpassword", account.getPassword());
    }

    @Test
    public void testManageAccount() {
        account.manageAccount();
        assertEquals(1, account.getAccountId());
    }

    @Test
    public void testCalculateRentalDuration() {
        long duration = rental.calculateDuration();
        assertEquals(2, duration);
    }

    @Test
    public void testCalculateRentalCharges() {
        double charges = rental.calculateCharges();
        assertEquals(20.0, charges, 0.01);
    }

    @Test
    public void testMakeReservation() {
        rental.makeReservation(bike, customer, staff);
        assertFalse(bike.isAvailable());
        assertTrue(rental.getState() instanceof ActiveState);
    }

    @Test
    public void testProcessEarlyReturn() {
        rental.setState(new ActiveState());
        rental.processEarlyReturn(LocalDateTime.now().minusHours(1));
        assertTrue(rental.getState() instanceof ReturnedState);
        assertEquals(1, rental.getRentalDuration());
    }

    @Test
    public void testAddLoyaltyPoints() {
        loyaltyProgram.addPoints(50);
        assertEquals(150, loyaltyProgram.getPoints());
    }

    @Test
    public void testRedeemLoyaltyPoints() {
        loyaltyProgram.redeemPoints(50);
        assertEquals(50, loyaltyProgram.getPoints());
    }

    @Test
    public void testRedeemLoyaltyPointsInsufficient() {
        loyaltyProgram.redeemPoints(150);
        assertEquals(100, loyaltyProgram.getPoints());
    }

    @Test
    public void testHandleDamageReport() {
        rental.handleDamageReport("Scratch on the frame");
        assertEquals(1, rental.getDamageReports().size());
        assertEquals("Scratch on the frame", rental.getDamageReports().get(0).getDescription());
    }

    @Test
    public void testGenerateAnalytics() {
        rental.generateAnalytics();
        assertNotNull(rental.getAnalytics());
        assertEquals("Trend Analysis", rental.getAnalytics().getRentalTrend());
    }

    @Test
    public void testProcessPayment() {
        Payment payment = new Payment(1, 100.0, "Credit Card");
        payment.processPayment();
        assertEquals(100.0, payment.getAmount(), 0.01);
        assertEquals("Credit Card", payment.getPaymentMethod());
    }

    @Test
    public void testReservationMakeAndCancel() {
        Reservation reservation = new Reservation(1, LocalDateTime.now(), customer, bike, staff);
        reservation.makeReservation();
        assertFalse(bike.isAvailable());
        reservation.cancelReservation();
        assertTrue(bike.isAvailable());
    }
}
