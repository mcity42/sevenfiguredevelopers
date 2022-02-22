package com.sevenfiguredevelopers;

public class User {
    private String name;
    private int earnings;
    private int currentLevel;

    // Constructors
    public User() {

    }

    public User(String name, int earnings, int currentLevel) {
        setName(name);
        setEarnings(earnings);
        setCurrentLevel(currentLevel);

    }

    // Methods
    public void winEarnings() {
        System.out.println("Level " + getCurrentLevel() + "" + getName() + "has won $" + getEarnings() + "! ");
    }

    // Getters and setters
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
        return "User{" +
                "name='" + getName() + '\'' +
                ", earnings=" + getEarnings() +
                ", currentLevel=" + getCurrentLevel() +
                '}';
    }
}
