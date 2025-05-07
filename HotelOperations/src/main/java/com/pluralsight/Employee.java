package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {

    // Declaring/initializing instance variables set to null or 0 by default
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    // Included for the punchIn/Out methods
    private double timePunchedIn;
    private boolean isPunchedIn;

    // Complete constructor that initializes all employee details
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters for employee info
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getPayRate() { return payRate; }
    public double getHoursWorked() { return hoursWorked; }
    // Derived getters for hour types
    public double getRegularHours() { return (hoursWorked >= 40) ? 40 : hoursWorked; }
    public double getOvertimeHours() { return (hoursWorked > 40) ? hoursWorked - 40 : 0; }
    // Derived getter for total pay
    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // punchIn method that is more basic and requires time input
    public void punchIn(double time) {
        timePunchedIn = time;
        isPunchedIn = true;
    }
    // punchIn method that gets the exact time and uses the basic method's logic
    public void punchIn(){
        LocalDateTime realTimeNow = LocalDateTime.now();
        double hourTime = realTimeNow.getHour();
        double minuteTime = realTimeNow.getMinute() / 60.0;
        double timeNow = hourTime + minuteTime;
        punchIn(timeNow);
    }
    // punchOut method that is more basic and requires time input
    public void punchOut(double time) {
        double punchHoursWorked = time - timePunchedIn;
        hoursWorked += punchHoursWorked;
        isPunchedIn = false;
    }
    // punchOut method that gets the exact time and uses the basic method's logic
    public void punchOut() {
        LocalDateTime realTimeNow = LocalDateTime.now();
        double hourTime = realTimeNow.getHour();
        double minuteTime = realTimeNow.getMinute() / 60.0;
        double timeNow = hourTime + minuteTime;
        punchOut(timeNow);
    }
}
