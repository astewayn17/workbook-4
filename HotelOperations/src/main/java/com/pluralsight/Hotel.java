package com.pluralsight;

public class Hotel {

    // Declaring/initializing instance variables set to null or 0 by default
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // First constructor with bookedSuites and bookedBasicRooms default to 0 and not needed in the parameters
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Second constructor that allows everything to be set
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Method to allow the use to book a room based on if it's a suite or not, if there are rooms available or not and
    // adds the requested rooms to the booked total
    public boolean bookRoom(int numberOfRoomsRequested, boolean isSuite) {
        if (isSuite) {
            if (getAvailableSuites() >= numberOfRoomsRequested) {
                bookedSuites += numberOfRoomsRequested;
                return true;
            }
        } else {
            if (getAvailableBasicRooms() >= numberOfRoomsRequested) {
                bookedBasicRooms += numberOfRoomsRequested;
                return true;
            }
        }
        return false;
    }

    // Derived getters for available rooms and suites based on subtracting the total number by the amount booked
    public int getAvailableSuites() { return numberOfSuites - bookedSuites; }
    public int getAvailableBasicRooms() { return numberOfRooms - bookedBasicRooms; }

    // Standard getters for the declared private variables
    public String getName() { return name; }
    public int getNumberOfSuites() { return numberOfSuites; }
    public int getNumberOfRooms() { return numberOfRooms; }
    public int getBookedSuites() { return bookedSuites; }
    public int getBookedBasicRooms() { return bookedBasicRooms; }
}
