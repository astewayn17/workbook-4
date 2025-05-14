package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) throws InterruptedException {

        // Creating 2 superPeople
        System.out.println("\n================ MAIN BATTLE ================\n");
        SuperHero hero = new SuperHero("Harry Potter", 100, 25);
        SuperVillain villain = new SuperVillain("Voldemort", 100, 25);
        // Pause
        Thread.sleep(3000);
        // Checking their health status
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());
        Thread.sleep(2000);
        // Loops while both superPeople are alive and while fighting each other
        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("\nIt is " + hero.getName() + "'s turn.");
            hero.fight(villain);
            System.out.println(villain.getStatus());

            Thread.sleep(2000);
            // Break loop if villain is dead
            if (!villain.isAlive()) { break; }

            System.out.println("\nIt is " + villain.getName() + "'s turn.");
            villain.fight(hero);
            System.out.println(hero.getStatus());

            Thread.sleep(2000);
            // Break loop if hero is dead
            if (!hero.isAlive()) { break; }
        }
        System.out.println("\nAfter a long and intense battle, it finally concluded...\n");
        Thread.sleep(3000);
        // Print the winner using getters and if statement
        if (hero.getHealth() > villain.getHealth()) {
            System.out.println(hero.getName() + " has defeated " + villain.getName() + "!");
        } else if (villain.getHealth() > hero.getHealth()) {
            System.out.println(villain.getName() + " has defeated " + hero.getName() + "!");
        } else {
            System.out.println("They tied!");
        }
        Thread.sleep(2000);
        // Printing the battle logs from the hash map used in the fight methods
        System.out.println("\n================ BATTLE LOGS ================\n");
        hero.printBattleLog();
        villain.printBattleLog();
    }
}
