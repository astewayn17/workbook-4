package com.pluralsight;

import java.util.Random;

public class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int darknessLevel) {
        super(name, health);
        System.out.println("The great super villain " + this.name +
                " has arrived with a darkness level of " + darknessLevel + "!\n");
    }
    @Override
    public void fight(SuperPerson enemy) {
        System.out.println(this.name + " is fighting " + enemy.name);
        int damage = new Random().nextInt(36);
        int bonusDamage = this.getRandomDeathlyHallow();
        damage += bonusDamage + this.experiencePoints;
        if (damage == 0) {
            System.out.println(enemy.name + " swings his wand frantically and " + this.name + " laughs and says \"You " +
                    "foolish boy, " + enemy.name + "! You missed me!\"");
        } else {
            enemy.takeDamage(damage);
            System.out.println("I the dark lord, " + this.name + " kicked " + enemy.name + "'s butt with "
                    + (damage) + " damage points!");
        }
        logHit(enemy);
    }

    public String getName() { return this.name; }
}
