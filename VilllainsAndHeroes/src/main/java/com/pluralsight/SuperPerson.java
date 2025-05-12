package com.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperPerson {

    // Protected properties so they can possibly be accessed by our children, grand children, etc...
    // These properties stay in the family
    protected String name;
    protected int health;
    protected int experiencePoints;

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

    //
    public void fight(SuperPerson opponent) {
        // Print out who we are fighting
        System.out.println(this.name + " is fighting " + opponent.name);
        // Generates a random amount of damage between 0-20
        int damageAmount = new Random().nextInt(21);
        // They take that random damage
        opponent.takeDamage(damageAmount);
    }

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

    public int getHealth() {
        return health;
    }

    // Creating a hashmap called battleLog
    private Map<String, Integer> battleLog = new HashMap<>();
    // Update the log entry for our SuperPerson
    public void logHit(SuperPerson enemy) {
        String name = enemy.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }
    // Print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    protected Map<String, Integer> inventory = new HashMap<>();

    public void addPowerUp(String item, int value) {
        inventory.put(item, value);
    }
}
