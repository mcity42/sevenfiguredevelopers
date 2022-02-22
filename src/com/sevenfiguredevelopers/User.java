package com.sevenfiguredevelopers;

public class User {
    private String name;
    private int earnings;
    private int currentLevel = 1;


    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public String toString() {
        return "Player: " +
                "Name='" + getName() + '\'' +
                ", Winnings= $" + getEarnings() +
                ", You're now on question " + (getCurrentLevel() + 1) +
                '.';
    }
}
