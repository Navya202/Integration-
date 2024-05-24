package com.example;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserTest {
    private BikeRentalSubSystem system;

    @Before
    public void setUp() {
        system = BikeRentalSubSystem.getInstance();
        system.addNewBikeToInventory("Mountain Bike", "BrandA", "B1", 1, "New");
        system.addNewBikeToInventory("Road Bike", "BrandB", "B2", 2, "Good");
    }

    @Test
    public void testRegisterUser() {
        User user = new User("john_doe", "password123", "john@example.com");
        system.registerUser(user);
        User authenticatedUser = system.authenticateUser("john_doe", "password123");
        assertNotNull("User should be registered and authenticated", authenticatedUser);
    }

    @Test
    public void testAuthenticateUser() {
        User user = new User("jane_doe", "password456", "jane@example.com");
        system.registerUser(user);
        User authenticatedUser = system.authenticateUser("jane_doe", "password456");
        assertNotNull("User should be authenticated", authenticatedUser);
    }

    @Test
    public void testRentBike() {
        User user = new User("john_doe", "password123", "john@example.com");
        system.registerUser(user);
        Bike bike = system.getBikeInventory().get(0);
        user.rentBike(bike, 2); // Pass the Bike object instead of model string
        assertFalse("Bike should be marked as not available after rental", bike.getStatus().equals("Available"));
    }
    

    @Test
    public void testReturnBike() {
        User user = new User("john_doe", "password123", "john@example.com");
        system.registerUser(user);
        Bike bike = system.getBikeInventory().get(0);
        user.rentBike(bike, 2); // Pass the Bike object instead of model string
        user.returnBike(bike.getBikeId()); // Pass the Bike ID directly
        assertTrue("Bike should be marked as available after return", bike.getStatus().equals("Available"));
    }
    

    @Test
    public void testAddBike() {
        int initialBikeCount = system.getBikeInventory().size();
        system.addNewBikeToInventory("Hybrid Bike", "BrandC", "B3", 3, "New");
        assertEquals("Bike count should increase by 1", initialBikeCount + 1, system.getBikeInventory().size());
    }

    @Test
    public void testTrackMaintenanceHistory() {
        Bike bike = system.getBikeInventory().get(0);
        system.scheduleMaintenance(bike.getBikeId(), new Date());
        system.trackMaintenanceHistory(bike.getBikeId());
        assertNotNull("Maintenance history should be tracked", bike.getMaintenanceRecord());
    }
}
