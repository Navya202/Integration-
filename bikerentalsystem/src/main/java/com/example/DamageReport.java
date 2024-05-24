package com.example;

import java.time.LocalDateTime;

public class DamageReport {
    private int reportId;
    private String description;
    private LocalDateTime reportedDate;

    public DamageReport(String description, LocalDateTime reportedDate) {
        this.description = description;
        this.reportedDate = reportedDate;
    }

    public void handleDamageReport() {
        // Logic to handle damage report
        System.out.println("Handling damage report: " + description);
    }

    // Getter
    public String getDescription() {
        return description;
    }
}