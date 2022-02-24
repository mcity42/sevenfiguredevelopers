package com.sevenfiguredevelopers;

/**
 *  Advanced enum constraints the Difficulty instances
 *  of each {@code Question} object to EASY, MEDIUM, HARD
 *  and sets the question's dollarAmount to the respective
 *  value
 *
 * @author Shi-Tian Liu
 * @version 1.0
 */
public enum Difficulty {
    EASY(150_000),
    MEDIUM(200_000),
    HARD(300_000);

    private int dollarAmount;

    Difficulty(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    public int getDollarAmount() {
        return dollarAmount;
    }
}