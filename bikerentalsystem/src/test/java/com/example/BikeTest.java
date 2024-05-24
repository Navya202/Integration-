package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {
    
    @Test
    void testBikeCreation() {
        Bike bike = new Bike(123, "Road Bike", "BrandA", "RB123", true);
        assertEquals("Road Bike", bike.getType());
        assertEquals("BrandA", bike.getBrand());
        assertEquals("RB123", bike.getModel());
        assertEquals("New", bike.getCondition());
        assertTrue(bike.isAvailable());
        assertEquals("", bike.getLocation());
        assertEquals("", bike.getMaintenanceRecord());
        assertEquals("Available", bike.getStatus());
    }

    @Test
    void testUpdateLocation() {
        Bike bike = new Bike(123, "Road Bike", "BrandA", "RB123", true);
        bike.setLocation("Location A");
        assertEquals("Location A", bike.getLocation());
    }

    @Test
    void testUpdateMaintenanceRecord() {
        Bike bike = new Bike(123, "Road Bike", "BrandA", "RB123", true);
        bike.setMaintenanceRecord("Maintenance done on 2024-05-17");
        assertEquals("Maintenance done on 2024-05-17", bike.getMaintenanceRecord());
    }

    @Test
    void testUpdateStatus() {
        Bike bike = new Bike(123, "Road Bike", "BrandA", "RB123", true);
        bike.setStatus("Rented");
        assertEquals("Rented", bike.getStatus());
    }
    
    @Test
    void testUpdateMultipleFields() {
        Bike bike = new Bike(123, "Road Bike", "BrandA", "RB123", true);
        bike.setLocation("Location A");
        bike.setMaintenanceRecord("Maintenance done on 2024-05-17");
        bike.setStatus("Rented");
        
        assertEquals("Location A", bike.getLocation());
        assertEquals("Maintenance done on 2024-05-17", bike.getMaintenanceRecord());
        assertEquals("Rented", bike.getStatus());
    }
}
