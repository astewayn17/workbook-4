package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Create a class using the extends keyword to copy functionality
// from the parent class (super class) to the child class (subclass)
public class SuperHero extends SuperPerson{

    // Constructor that calls the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);
        // In the parent renaming exp from the parent class to powerLevel for heroes
        this.experiencePoints = powerLevel;
        // Let the world know the hero now exists
        System.out.println("The great superhero " + this.name + " has arrived with a power level of " + powerLevel + "!");
    }

    @Override
    public void fight(SuperPerson enemy) {
        // Print out who we are fighting
        System.out.println(this.name + " is fighting " + enemy.name);
        // Generates a random amount of damage between 0-35
        int damageAmount = new Random().nextInt(36);
        if (damageAmount == 0) {
            System.out.println("Haha lame ahh villain, " + enemy.name + "! You missed me!");
        } else {
            // They take that random damage + the power level (exp pts of the hero)
            enemy.takeDamage(damageAmount + this.experiencePoints);
            System.out.println("I the great " + this.name + " kicked " + enemy.name + "'s butt with "
                    + (damageAmount + this.experiencePoints) + " damage points!");
        }
        logHit(enemy);
        // Create a new list of just the keys from the HashMap (glove, hammer, etc....)
        List<String> items = new ArrayList<>(inventory.keySet());
        // Get a random item name from the above list we just made and store it in randomItem
        String randomItem = items.get(new Random().nextInt(items.size()));
        // Get the point value for that item from the inventory HashMap
        // Bonuses would be the int that represents the damage the item will do
        int bonus = inventory.get(randomItem);
        System.out.println(this.name + " activated a " + randomItem + " power-up! (causing " + bonus + " bonus damage!)");
    }

    public String getName() {
        return this.name;
    }
}
