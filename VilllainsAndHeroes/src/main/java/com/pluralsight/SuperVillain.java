package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperVillain extends SuperPerson {

    public SuperVillain(String name, int health, int darknessLevel) {
        super(name, health);

        this.experiencePoints = darknessLevel;

        System.out.println("The great super villain " + this.name + " has arrived with a darkness level of " + darknessLevel + "!\n");
    }

    @Override
    public void fight(SuperPerson enemy) {
        System.out.println(this.name + " is fighting " + enemy.name);
        int damageAmount = new Random().nextInt(41);
        if (damageAmount == 0) {
            System.out.println("You foolish hero, " + enemy.name + "! You missed me!");
        } else {
            enemy.takeDamage(damageAmount + this.experiencePoints);
            System.out.println("I the dark lord " + this.name + " kicked " + enemy.name + "'s butt with "
                    + (damageAmount + this.experiencePoints) + " damage points!");
        }
        logHit(enemy);
        List<String> items = new ArrayList<>(inventory.keySet());
        String randomItem = items.get(new Random().nextInt(items.size()));
        int bonus = inventory.get(randomItem);
        System.out.println(this.name + " activated a " + randomItem + " power-up! (causing " + bonus + " bonus damage!)");
    }

    public String getName() {
        return this.name;
    }
}
