package com.iquest.java.models;

public class User {

    private String name;
    private String username;
    private double balance;

    public User() {}

    public User(String name, String username, double balance) {
        this.name = name;
        this.username = username;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
