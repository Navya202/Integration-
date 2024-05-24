package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeRentalSystem {
    private List<User> users;
    private List<Bike> bikes;

    public BikeRentalSystem() {
        this.users = new ArrayList<>();
        this.bikes = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getUsername());
    }

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

    public void addBike(int bikeId, String model, String condition) {
        bikes.add(new Bike(bikeId, "Generic", "BrandX", model, true));
        System.out.println("Bike added: " + bikeId);
    }

    public void updateBike(int bikeId, String model, String condition) {
        for (Bike bike : bikes) {
            if (bike.getBikeId() == bikeId) {
                bike.updateDetails(model, condition);
                System.out.println("Bike updated: " + bikeId);
                return;
            }
        }
        System.out.println("Bike not found: " + bikeId);
    }

    public void removeBike(int bikeId) {
        bikes.removeIf(bike -> bike.getBikeId() == bikeId);
        System.out.println("Bike removed: " + bikeId);
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public static void main(String[] args) {
        BikeRentalSystem system = new BikeRentalSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample data for demonstration
        system.addBike(1, "Mountain Bike", "New");
        system.addBike(2, "Road Bike", "Good");

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Authenticate User");
            System.out.println("3. Add Bike");
            System.out.println("4. Update Bike");
            System.out.println("5. Remove Bike");
            System.out.println("6. Browse Bikes");
            System.out.println("7. Rent Bike");
            System.out.println("8. Return Bike");
            System.out.println("9. View Rental History");
            System.out.println("10. View Rental Charges");
            System.out.println("11. Generate Rental Invoice");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter contact details: ");
                    String contactDetails = scanner.nextLine();
                    system.registerUser(new User(username, password, contactDetails));
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String authUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String authPassword = scanner.nextLine();
                    User user = system.authenticateUser(authUsername, authPassword);
                    if (user != null) {
                        boolean isAuthenticated = true;
                        while (isAuthenticated) {
                            // Implement user actions as needed
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter bike ID: ");
                    int newBikeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter condition: ");
                    String condition = scanner.nextLine();
                    system.addBike(newBikeId, model, condition);
                    break;
                case 4:
                    System.out.print("Enter bike ID: ");
                    int updateBikeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new model: ");
                    String newModel = scanner.nextLine();
                    System.out.print("Enter new condition: ");
                    String newCondition = scanner.nextLine();
                    system.updateBike(updateBikeId, newModel, newCondition);
                    break;
                case 5:
                    System.out.print("Enter bike ID: ");
                    int removeBikeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.removeBike(removeBikeId);
                    break;
                case 6:
                    for (Bike bike : system.getBikes()) {
                        System.out.println(bike);
                    }
                    break;
                case 12:
                    scanner.close();
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
