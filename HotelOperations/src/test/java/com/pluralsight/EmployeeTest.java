package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void inputtedPunchInAndPunchOut_should_measureTimeWorkedCorrectly() {
        // Arrange
        Employee yaBoi = new Employee(123, "Asteway", "IT", 35.50, 0);
        // Act
        yaBoi.punchIn(10.00);
        yaBoi.punchOut(17.50);
        // Assert
        assertEquals(7.50, yaBoi.getHoursWorked());
    }
    @Test
    public void realPunchInAndPunchOut_should_measureTimeWorkedCorrectly() {
        // Arrange
        Employee yaBoi = new Employee(123, "Asteway", "IT", 35.50, 0);
        // Act
        yaBoi.punchIn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yaBoi.punchOut();
        // Assert
        assertTrue(yaBoi.getHoursWorked() == (1/3600));
    }
}