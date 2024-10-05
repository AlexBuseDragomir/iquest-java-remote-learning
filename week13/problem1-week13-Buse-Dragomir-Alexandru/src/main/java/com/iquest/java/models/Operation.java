package com.iquest.java.models;

public class Operation {

    private double amount;
    private String description;
    private int userId;

    public Operation(double amount, String description, int userId) {
        this.amount = amount;
        this.description = description;
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
