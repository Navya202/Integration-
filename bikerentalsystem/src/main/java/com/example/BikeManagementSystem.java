package com.example;

public class BikeManagementSystem {
    public static void main(String[] args) {
        BikeRentalSubSystem bikeRentalSystem = BikeRentalSubSystem.getInstance();

        // Adding new bikes to the inventory
        bikeRentalSystem.addNewBikeToInventory("Mountain Bike", "Giant", "ATX", 12345, "New");
        bikeRentalSystem.addNewBikeToInventory("Road Bike", "Trek", "Domane", 67890, "New");

        // Updating bike information
        bikeRentalSystem.updateBikeInformation(12345, "Location A", "Checked", "Available");

        // Removing a bike from service
        bikeRentalSystem.removeBikeFromService(67890);

        // Retiring a bike
        bikeRentalSystem.retireBike(12345);

        // Printing bike inventory
        for (Bike bike : bikeRentalSystem.getBikeInventory()) {
            System.out.println("Bike Model: " + bike.getModel() + ", Bike ID: " + bike.getBikeId());
        }

        // User actions
        User user = new User("john_doe", "password123", "john@example.com");

        // Simulating user actions
        user.register();
        if (user.authenticate("password123")) {
            user.browseAvailableBikes(bikeRentalSystem.getBikeInventory());
            Bike bikeToRent = bikeRentalSystem.findBikeByBikeId(12345);
            if (bikeToRent != null) {
                user.rentBike(bikeToRent, 7);
            }
        }
    }
}
