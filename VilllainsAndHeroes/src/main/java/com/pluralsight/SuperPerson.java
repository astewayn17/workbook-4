package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class SuperPerson {

    // Protected properties so they can possibly be accessed by our children, grand children, etc...
    // These properties stay in the family
    protected String name;
    protected int health;
    protected int experiencePoints;
    // Private hash map that stores the deathly hallows and shares them between the classes.
    // Each power up (key) has a damage amount (value)
    protected static Map<String, Integer> inventory = new HashMap<>();
    // Private hash map that keeps track of the hit count of each enemy. Key is the enemy, value is the hit count
    private Map<String, Integer> battleLog = new HashMap<>();

    // Constructor
    public SuperPerson(String name, int health) {
        this.name = name;
        this.health = health;
        // Default exp points to zero
        this.experiencePoints = 0;
    }

    // If they have health, they are alive, return true, otherwise false
    public boolean isAlive() {
        // This will return true or false
        return this.health > 0;
    }

    // Abstract super class fight method that is being overridden in subclasses
    public abstract void fight(SuperPerson enemy);

    // This method allows a super person to take damage
    public void takeDamage(int damageAmount) {
        // Subtract the damage amount from the health but don't want to ever set our health below 0
        this.health -= damageAmount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // A way to ask the super person how they are doing
    public String getStatus() {
        // Build and return a string that tells us how the SuperPerson is doing
        return this.name + " has " + this.health + " health left!";
    }

    // Returns the health amount of the super person
    public int getHealth() { return health; }

    // Update the log entry for our SuperPerson
    public void logHit(SuperPerson enemy) {
        // Get the current hit count for the enemy (default to 0 if this is the first hit)
        int count = battleLog.getOrDefault(enemy.name, 0);
        // Increment the count and update the battle log to reflect this new hit
        battleLog.put(enemy.name, count + 1);
    }

    // Print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        // Loops through the battle log and prints how many hits
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    //
    public String getType() {
        return this.getClass().getSimpleName();
    }

    // Static block to initialize the shared Deathly Hallows only once
    static {
        inventory.put("Elder Wand", 10);
        inventory.put("Resurrection Stone", 12);
        inventory.put("Cloak of Invisibility", 7);
    }

    // Method to obtain a random deathly hallow
    public int getRandomDeathlyHallow() {
        // Initializing bonusDamage
        int bonusDamage = 0;
        // Only use a Deathly Hallow if there's at least one left in the
        // inventory and there's a 40% chance for it to be triggered this turn
        if (!inventory.isEmpty() && new Random().nextInt(100) < 40) {
            // Create a new list of just the keys from the HashMap (glove, hammer, etc....)
            ArrayList<String> items = new ArrayList<String>(inventory.keySet());
            // Get a random item name from the above list we just made and store it in randomItem
            String randomItem = items.get(new Random().nextInt(items.size()));
            // Get the point value for that item from the inventory HashMap
            // Bonus would be the int that represents the damage the item will do.
            bonusDamage = inventory.get(randomItem);
            System.out.println(this.name + " equipped the " + randomItem + " Deathly Hallow! " +
                    "(providing " + bonusDamage + " bonus damage!)");
            inventory.remove(randomItem);
        } else if (!inventory.isEmpty()) {
            System.out.println(this.name + " couldn't use a deathly hallow this turn.");
        }
        return bonusDamage;
    }
}
