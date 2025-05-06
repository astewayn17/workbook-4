package com.pluralsight;

public class Reservation {

    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        double price = 0;
        if (roomType.equalsIgnoreCase("king")) { price = 139.00; }
        else if (roomType.equalsIgnoreCase("double")) { price = 124.00; }
        if (isWeekend) { price *= 1.1; }
        return price;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public int getNumberOfNights() { return numberOfNights; }
    public void setNumberOfNights(int numberOfNights) { this.numberOfNights = numberOfNights; }

    public boolean isWeekend() { return isWeekend; }
    public void setIsWeekend(boolean isWeekend) { this.isWeekend = isWeekend; }
}
