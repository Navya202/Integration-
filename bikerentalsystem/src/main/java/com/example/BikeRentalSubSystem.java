package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

interface BikeOperations {
    void addNewBikeToInventory(String type, String brand, String model, int bikeId, String initialCondition);
    void updateBikeInformation(int bikeId, String location, String maintenanceRecord, String status);
    void removeBikeFromService(int bikeId);
    void retireBike(int bikeId);
    void monitorBikeAvailability();
    void rentBike(String bikeModel, int rentalDuration);
    void returnBike(int bikeId);
    void trackMaintenanceHistory(int bikeId);
    void scheduleMaintenance(int bikeId, Date date);
    Bike findBikeByBikeId(int bikeId); // Updated method declaration
    List<Bike> getBikeInventory();
    void registerUser(User user); // Add registerUser method
    User authenticateUser(String username, String password); // Add authenticateUser method
}

class BikeRentalSubSystem implements BikeOperations {
    private static BikeRentalSubSystem instance;
    private List<Bike> bikeInventory;
    private List<User> users;

    private BikeRentalSubSystem() {
        bikeInventory = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static synchronized BikeRentalSubSystem getInstance() {
        if (instance == null) {
            instance = new BikeRentalSubSystem();
        }
        return instance;
    }

    @Override
    public void addNewBikeToInventory(String type, String brand, String model, int bikeId, String initialCondition) {
        Bike bike = new Bike(bikeId, type, brand, model, true);
        bike.setCondition(initialCondition);
        bikeInventory.add(bike);
        System.out.println("Added new bike: " + model + ", Bike ID: " + bikeId);
    }

    @Override
    public void updateBikeInformation(int bikeId, String location, String maintenanceRecord, String status) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId) {
                bike.setLocation(location);
                bike.setMaintenanceRecord(maintenanceRecord);
                bike.setStatus(status);
                System.out.println("Updated bike information: " + bikeId);
            }
        }
    }

    @Override
    public void removeBikeFromService(int bikeId) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId) {
                bike.setStatus("Out of Service");
                System.out.println("Removed bike from service: " + bikeId);
            }
        }
    }

    @Override
    public void retireBike(int bikeId) {
        bikeInventory.removeIf(bike -> bike.getBikeId() == bikeId);
        System.out.println("Retired bike: " + bikeId);
    }

    @Override
    public void monitorBikeAvailability() {
        for (Bike bike : bikeInventory) {
            System.out.println("Bike Model: " + bike.getModel() + ", Bike ID: " + bike.getBikeId() + ", Status: " + bike.getStatus());
        }
    }

    @Override
    public void rentBike(String bikeModel, int rentalDuration) {
        for (Bike bike : bikeInventory) {
            if (bike.getModel().equals(bikeModel) && bike.getStatus().equals("Available")) {
                bike.setStatus("Rented");
                System.out.println("Bike rented: " + bike.getModel() + " for duration: " + rentalDuration + " days.");
                return;
            }
        }
        System.out.println("Bike model: " + bikeModel + " is not available.");
    }

    @Override
    public void returnBike(int bikeId) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId && bike.getStatus().equals("Rented")) {
                bike.setStatus("Available");
                System.out.println("Bike returned: " + bike.getModel() + ".");
                return;
            }
        }
        System.out.println("Bike with Bike ID: " + bikeId + " is not found or not rented.");
    }

    @Override
    public void trackMaintenanceHistory(int bikeId) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId) {
                System.out.println("Maintenance Record for Bike ID: " + bikeId + " - " + bike.getMaintenanceRecord());
                return;
            }
        }
        System.out.println("Bike with Bike ID: " + bikeId + " is not found.");
    }

    @Override
    public void scheduleMaintenance(int bikeId, Date date) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId) {
                bike.setMaintenanceRecord("Maintenance scheduled on: " + date.toString());
                bike.setStatus("Under Maintenance");
                System.out.println("Maintenance scheduled for Bike ID: " + bikeId + " on: " + date);
                return;
            }
        }
        System.out.println("Bike with Bike ID: " + bikeId + " is not found.");
    }

    @Override
    public Bike findBikeByBikeId(int bikeId) {
        for (Bike bike : bikeInventory) {
            if (bike.getBikeId() == bikeId) {
                return bike;
            }
        }
        return null;
    }

    public List<Bike> getBikeInventory() {
        return bikeInventory;
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getUsername());
    }

    @Override
    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                System.out.println("User authenticated: " + username);
                return user;
            }
        }
        System.out.println("Authentication failed for: " + username);
        return null;
    }

    

    
}
