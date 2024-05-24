package com.example;

public class Bike {
    private int bikeId;
    private String type;
    private String brand;
    private String model;
    private String condition;
    private boolean available;
    private String location; // Assuming this is also needed
    private String maintenanceRecord;
    private String status;

    // Constructor
    public Bike(int bikeId, String type, String brand, String model, boolean available) {
        this.bikeId = bikeId;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.condition = "New";
        this.available = available;
        this.location = "";
        this.maintenanceRecord = "";
        this.status = "Available";
    }

    // Getters and setters
    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaintenanceRecord() {
        return maintenanceRecord;
    }

    public void setMaintenanceRecord(String maintenanceRecord) {
        this.maintenanceRecord = maintenanceRecord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Additional methods
    public void updateDetails(String model, String condition) {
        this.model = model;
        this.condition = condition;
    }

    public boolean matchesCriteria(String criteria) {
        return model.contains(criteria) || condition.contains(criteria);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", condition='" + condition + '\'' +
                ", available=" + available +
                '}';
    }
}
