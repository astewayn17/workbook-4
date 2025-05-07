package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_should_beOccupiedAndDirty() {
        // Arrange
        Room r1 = new Room (2, 145.99, false, false);
        // Act
        r1.checkIn();
        // Assert
        assertTrue(r1.isOccupied() && r1.isDirty());
        assertFalse(r1.isAvailable());
    }
    @Test
    public void checkOut_should_beUnoccupiedAndDirty() {
        // Arrange
        Room r1 = new Room (2, 145.99, false, false);
        // Act
        r1.checkOut();
        // Assert
        assertTrue(r1.isDirty());
        assertFalse(r1.isAvailable() && r1.isOccupied());
    }
    @Test
    public void cleanRoom_should_makeARoomAvailable() {
        // Arrange
        Room r1 = new Room (2, 145.99, false, false);
        // Act
        r1.cleanRoom();
        // Assert
        assertTrue(r1.isAvailable());
        assertFalse(r1.isOccupied() && r1.isDirty());
    }
}
