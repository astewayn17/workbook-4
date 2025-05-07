package com.pluralsight;

public class Room {

    // Declaring/initializing instance variables set to null or 0 by default
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // Complete constructor that initializes room details
    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    // Method to say whether a room is available based on if its dirty or occupied
    public boolean isAvailable() { return !isDirty && !isOccupied; }

    // Getters and booleans that return statuses or values
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPrice() { return price; }
    public boolean isOccupied() { return isOccupied; }
    public boolean isDirty() { return isDirty; }

    // Check-in/out, clean room that change the declared variables
    public void checkIn() {
        isOccupied = true;
        isDirty = true;
    }
    public void checkOut() {
        isOccupied = false;
        isDirty = true;
    }
    public void cleanRoom() {
        isDirty = false;
    }
}
