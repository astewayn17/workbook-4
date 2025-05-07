package com.pluralsight;

public class TheApp {

    public static void main(String[] args) {

        System.out.println("\n// ROOM CLASS // ====================================================================\n");

        // Instantiating a Room object using the parameterized constructor
        Room room1 = new Room( 3, 150.99, false, false);
        // Checking if everything prints correctly for an available room
        System.out.println("Is room r1 available? " + room1.isAvailable());
        System.out.println("How many beds does room r1 have? " + room1.getNumberOfBeds());
        System.out.printf("How much does room r1 cost? $%.2f%n", room1.getPrice());
        System.out.println("Is room r1 occupied? " + room1.isOccupied());
        System.out.println("Is room r1 dirty? " + room1.isDirty());
        // Checking in
        room1.checkIn();
        // Verifying the room will not be available and is occupied/dirty when checked in
        System.out.println("\nIs room r1 available? " + room1.isAvailable());
        System.out.println("Is room r1 occupied? " + room1.isOccupied());
        System.out.println("Is room r1 dirty? " + room1.isDirty());
        // Checking out
        room1.checkOut();
        // Verifying the room will not be available and is dirty when checked out
        System.out.println("\nIs room r1 available? " + room1.isAvailable());
        System.out.println("Is room r1 occupied? " + room1.isOccupied());
        System.out.println("Is room r1 dirty? " + room1.isDirty());
        // Cleaning the room
        room1.cleanRoom();
        // Verifying the room will be available and is not occupied/dirty
        System.out.println("\nIs room r1 available? " + room1.isAvailable());
        System.out.println("Is room r1 occupied? " + room1.isOccupied());
        System.out.println("Is room r1 dirty? " + room1.isDirty());

        System.out.println("\n// RESERVATION CLASS // =============================================================\n");

        // Instantiating a Reservation object using the parameterized constructor
        Reservation res1 = new Reservation( "king", 4, true);
        // Verifying the info is correct based on the getters
        System.out.printf("How much will my reservation cost? $%.2f%n", res1.getPrice());
        System.out.printf("How much will the total cost of the reservation be? $%.2f%n", res1.getReservationTotal());
        System.out.println("What is the room type? " + res1.getRoomType());
        System.out.println("How many nights is my reservation? " + res1.getNumberOfNights());
        System.out.println("Does my reservation fall on a weekend? " + res1.isWeekend());
        // Changing the values with setters
        res1.setRoomType("double");
        res1.setIsWeekend(false);
        res1.setNumberOfNights(3);
        // Verifying yhr changed values reflect
        System.out.printf("\nHow much will my reservation cost? $%.2f%n", res1.getPrice());
        System.out.printf("How much will the total cost of the reservation be? $%.2f%n", res1.getReservationTotal());
        System.out.println("What is the room type? " + res1.getRoomType());
        System.out.println("How many nights is my reservation? " + res1.getNumberOfNights());
        System.out.println("Does my reservation fall on a weekend? " + res1.isWeekend());

        System.out.println("\n// EMPLOYEE CLASS // ================================================================\n");

        // Instantiating an employee object using the parameterized constructor
        Employee yaBoi = new Employee(745, "Asteway", "IT", 25.50, 0);
        // Employee punching in
        yaBoi.punchIn();
        System.out.println("Punched in!");
        System.out.println("Waiting a minute...");
        // Waiting a minute to record a short work shift to test
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // Employee punching out
        yaBoi.punchOut();
        System.out.println("Punched out!");
        // Showing the results
        System.out.println("Employee name: " + yaBoi.getName());
        System.out.println("Employee department: " + yaBoi.getDepartment());
        System.out.printf("Employee pay rate: %.2f per hour.", yaBoi.getPayRate());
        System.out.printf("\nHours worked: $%.6f%n", yaBoi.getHoursWorked());
        System.out.printf("Regular hours worked: %.2f%n", yaBoi.getRegularHours());
        System.out.printf("Overtime hours worked: %.2f%n", yaBoi.getOvertimeHours());
        System.out.printf("Total pay: $%.2f%n", yaBoi.getTotalPay());

        System.out.println("\n// HOTEL CLASS // ===================================================================\n");

        // Instantiating a hotel object using the first partially parameterized constructor
        Hotel daTelly = new Hotel("Asteway's Resort", 50, 70);
        // Print initial availability
        System.out.printf("%s has %d rooms in total and %d suites in total.\n",
                daTelly.getName(), daTelly.getNumberOfRooms(), daTelly.getNumberOfSuites());
        // Attempts to book basic rooms
        boolean bookingBasic = daTelly.bookRoom(25, false);
        System.out.println("Booking 5 basic rooms: " + bookingBasic);
        // Attempts to book suites
        boolean bookingSuites = daTelly.bookRoom(50, true);
        System.out.println("Booking 3 suites: " + bookingSuites);
        // Attempts to book suites again
        boolean bookingSuites2 = daTelly.bookRoom(35, true);
        System.out.println("Booking 12 more suites: " + bookingSuites2);
        // Shows the availability after booking
        System.out.println("What suites are now available? " + daTelly.getAvailableSuites());
        System.out.println("What basic rooms are now available? " + daTelly.getAvailableBasicRooms());
        System.out.println("How many suites are booked? " + daTelly.getBookedSuites());
        System.out.println("How many basic rooms are booked? " + daTelly.getBookedBasicRooms());
    }
}