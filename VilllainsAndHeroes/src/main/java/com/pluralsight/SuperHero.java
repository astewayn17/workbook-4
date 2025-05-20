package com.pluralsight;

import java.util.Random;

// Create a class using the extends keyword to copy functionality
// from the parent class (super class) to the child class (subclass)
public class SuperHero extends SuperPerson implements Fightable {

    // Constructor that calls the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);
        // In the parent renaming exp from the parent class to powerLevel for heroes
        this.experiencePoints = powerLevel;
        // Let the world know the hero now exists
        System.out.println("The great superhero " + this.name +
                " has arrived with a power level of " + powerLevel + "!");
    }

    // Overriding the fight method from the super class
    @Override
    public void fight(SuperPerson enemy) {
        // Print out who we are fighting
        System.out.println(this.name + " is fighting " + enemy.name);
        // Generates a random amount of damage between 0-35
        int damage = new Random().nextInt(31);
        //generate bonus damage from random weapon in inventory
        int bonusDamage = this.getRandomDeathlyHallow();
        damage += bonusDamage + this.experiencePoints;
        //
        if (damage == 0) {
            System.out.println("The dark lord, " + enemy.name + " flicked his wand and it missed " + this.name + "!");
        } else {
            // They take that random damage + the power level (exp pts of the hero)
            enemy.takeDamage(damage);
            System.out.println("I the Chosen One " + this.name + " kicked " + enemy.name + "'s butt with "
                    + damage + " damage points!");
        }
        //
        logHit(enemy);
    }

    // Simple getter for the superHero's name
    public String getName() { return this.name; }
}
