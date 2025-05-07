package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    public void bookRoom_should_increaseBookedSuites() {
        // Arrange
        Hotel theTelly = new Hotel("Asteway's Telly", 10, 50);
        // Act
        theTelly.bookRoom(3, true);
        // Assert
        assertEquals(7, theTelly.getAvailableSuites());
    }
    @Test
    public void bookRoom_should_increaseBookedRooms() {
        // Arrange
        Hotel theTelly = new Hotel("Asteway's Telly", 10, 50);
        // Act
        theTelly.bookRoom(15, false);
        // Assert
        assertEquals(35, theTelly.getAvailableRooms());
    }
    @Test
    public void bookRoom_should_returnFalseIfNoSuitesAvailable() {
        // Arrange
        Hotel theTelly = new Hotel("Asteway's Telly", 10, 50);
        // Act
        boolean allowed = theTelly.bookRoom(11, true);
        // Assert
        assertFalse(allowed);
    }
}