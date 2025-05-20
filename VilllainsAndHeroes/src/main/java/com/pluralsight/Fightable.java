package com.pluralsight;

public interface Fightable {

    // Add methods for fight, isAlive and getStatus
    void fight(SuperPerson opponent);
    boolean isAlive();
    String getStatus();
}
