package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {

        // Creating 2 superPeople
        System.out.println("\n================ MAIN BATTLE ================\n");
        SuperHero hero = new SuperHero("Batman", 100, 25);
        SuperVillain villain = new SuperVillain("Joker", 100, 30);

        // Checking their health status
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());

        // Loop for while both are alive and them fighting each other
        while (hero.isAlive() && villain.isAlive()) {
            System.out.println("\nIt is " + hero.getName() + "'s turn.");
            hero.addPowerUp("Gun", 8);
            hero.fight(villain);
            villain.getStatus();

            if (!villain.isAlive()) { break; }

            System.out.println("\nIt is " + villain.getName() + "'s turn.");
            villain.addPowerUp("Grenade", 10);
            villain.fight(hero);
            hero.getStatus();
            break;
        }

        System.out.println("\nAfter an intense battle, it finally concluded...\n");

        // Print the winner
        if (hero.getHealth() > villain.getHealth()) {
            System.out.println(hero.getName() + " has defeated " + villain.getName() + "!");
        } else if (villain.getHealth() > hero.getHealth()) {
            System.out.println(villain.getName() + " has defeated " + hero.getName() + "!");
        } else {
            System.out.println("They tied!");
        }

        // Printing the battle logs from the hash map used in the fight methods
        System.out.println("\n================ BATTLE LOGS ================\n");
        hero.printBattleLog();
        villain.printBattleLog();
    }
}
