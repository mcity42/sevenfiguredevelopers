package com.sevenfiguredevelopers;

enum Difficulty {
    EASY(150_000),
    MEDIUM(200_000),
    HARD(300_000);

    private int dollarAmount;

    Difficulty(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }
}