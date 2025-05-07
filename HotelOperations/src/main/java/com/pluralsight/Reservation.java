package com.pluralsight;

public class Reservation {

    // Declaring/initializing instance variables set to null or 0 by default
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    // Complete constructor that initializes reservation details
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Method to calculate price based on room type and whether it's a weekend or not
    public double getPrice() {
        double price = 0;
        if (roomType.equalsIgnoreCase("king")) { price = 139.00; }
        else if (roomType.equalsIgnoreCase("double")) { price = 124.00; }
        if (isWeekend) { price *= 1.1; }
        return price;
    }

    // Derived getter to obtain the reservation total based on the calculated price and number of nights stayed
    public double getReservationTotal() { return getPrice() * numberOfNights; }

    // Getters and setters for the variables if they need to be accessed or changed
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public int getNumberOfNights() { return numberOfNights; }
    public void setNumberOfNights(int numberOfNights) { this.numberOfNights = numberOfNights; }
    public boolean isWeekend() { return isWeekend; }
    public void setIsWeekend(boolean isWeekend) { this.isWeekend = isWeekend; }
}
