package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class BikeRentalSubSystemTest {
    
    private BikeOperations bikeRentalSystem;
    
    @BeforeEach
    void setUp() {
        bikeRentalSystem = BikeRentalSubSystem.getInstance();
        bikeRentalSystem.getBikeInventory().clear();
    }
    
    @Test
    void testSingletonInstance() {
        BikeOperations anotherInstance = BikeRentalSubSystem.getInstance();
        assertSame(bikeRentalSystem, anotherInstance);
    }

    @Test
    void testAddNewBikeToInventory() {
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "BrandA", "ModelX", 1, "New");
        List<Bike> inventory = ((BikeRentalSubSystem) bikeRentalSystem).getBikeInventory();
        assertEquals(1, inventory.size());
        assertEquals(1, inventory.get(0).getBikeId());
    }

    @Test
    void testUpdateBikeInformation() {
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "BrandA", "ModelX", 1, "New");
        bikeRentalSystem.updateBikeInformation(1, "Location A", "Checked", "Available");
        Bike bike = ((BikeRentalSubSystem) bikeRentalSystem).getBikeInventory().get(0);
        assertEquals("Location A", bike.getLocation());
        assertEquals("Checked", bike.getMaintenanceRecord());
        assertEquals("Available", bike.getStatus());
    }

    @Test
    void testRemoveBikeFromService() {
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "BrandA", "ModelX", 1, "New");
        bikeRentalSystem.removeBikeFromService(1);
        Bike bike = ((BikeRentalSubSystem) bikeRentalSystem).getBikeInventory().get(0);
        assertEquals("Out of Service", bike.getStatus());
    }

    @Test
    void testRentAndReturnBike() {
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "BrandA", "ModelX", 1, "New");
        bikeRentalSystem.rentBike("ModelX", 5);
        Bike bike = ((BikeRentalSubSystem) bikeRentalSystem).getBikeInventory().get(0);
        assertEquals("Rented", bike.getStatus());

        bikeRentalSystem.returnBike(1);
        assertEquals("Available", bike.getStatus());
    }

    @Test
    void testMonitorBikeAvailability() {
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "BrandA", "ModelX", 1, "New");
        bikeRentalSystem.addNewBikeToInventory("Mountain Bike", "BrandB", "ModelY", 2, "New");
        bikeRentalSystem.rentBike("ModelX", 5);

        bikeRentalSystem.monitorBikeAvailability(); // Here, we assume it prints the available bikes
        List<Bike> inventory = ((BikeRentalSubSystem) bikeRentalSystem).getBikeInventory();
        assertEquals("Rented", inventory.get(0).getStatus());
        assertEquals("Available", inventory.get(1).getStatus());
    }
}
