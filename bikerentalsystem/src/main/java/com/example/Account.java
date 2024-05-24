package com.example;

public class Account {
    private int accountId;
    private String username;
    private String password;

    public Account(int accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public void manageAccount() {
        // Logic to manage account
        System.out.println("Managing account ID: " + accountId);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed for account ID: " + accountId);
    }

    // Getters
    public int getAccountId() {
        return accountId;
    }

    public String getPassword() {
        return password;
    }
}



