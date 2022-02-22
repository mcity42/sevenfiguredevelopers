package com.sevenfiguredevelopers.controller;

import com.apps.util.Prompter;
import com.sevenfiguredevelopers.Question;
import com.sevenfiguredevelopers.QuestionDB;
import com.sevenfiguredevelopers.User;

import java.util.*;
import java.util.Scanner;

public class SevenFigureDeveloperApp {
    private Boolean isPlaying = false;
    private int maxLevel = 15;
    private int index = 0;
    QuestionDB questionDB = new QuestionDB();
    Prompter prompter = new Prompter(new Scanner(System.in));
    User user = new User();

    public void execute() {
        promptForName();
        isPlaying = true;
        promptForDifficulty();
        findNextQuestion();
    }

    private void promptForName() {
        user.setName(null);
        boolean isValid = false;
        String input = prompter.prompt("Enter your name: ", "\\w+", "Invalid name");
        user.setName(input);
    }

    private void promptForDifficulty() {
        int difficulty;
        String input = prompter.prompt("Select 1 for easy, 2 for intermediate, 3 for hard: ", "1|2|3", "Invalid selection");
        difficulty = Integer.parseInt(input);
        switch (difficulty) {
            case 1:
                maxLevel = 5;
                break;
            case 2:
                maxLevel = 10;
                break;
            case 3:
                maxLevel = 15;
        }
    }

    private void findNextQuestion() {
        for (int i = 0; i < maxLevel; i++) {
            for (Question question : questionDB.getQuestionDatabase()) {
                if (isPlaying) {
                    if (index > (maxLevel - 1) && (user.getEarnings() >= 1_000_000)) {
                        System.out.println("Your total is: $" + user.getEarnings() + "!! You are a Seven Figure Developer!!");
                        System.out.println("Please restart.");
                        isPlaying = false;
                        break;
                    }
                    question.askQuestion();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
                    index++;
                }
            }
        }
    }

    private void promptForAnswer(Question question) {
        String input = prompter.prompt("Choose A, B, C, or D: ", "A|B|C|D|a|b|c|d", "Error, please enter A, B, C, or D");
        isPlaying = question.checkAnswer(input.toUpperCase(Locale.ROOT));
    }

    private boolean promptToContinue() {
        boolean continuePlaying = isPlaying;
        if (isPlaying) {
            String input = prompter.prompt("Choose 1 to continue or 2 to exit with earnings. ", "1|2", "Error, please enter 1 or 2.");
            if (input.equals("1")) {
                continuePlaying = true;
            } else if (input.equals("2")) {
                System.out.println("Great game you won: $" + user.getEarnings());
                continuePlaying = false;
                isPlaying = false;
            }
        }
        return continuePlaying;
    }

    private void showWinnings(Question question) {
        if (isPlaying) {
            int winnings = question.getDifficulty().getDollarAmount() + user.getEarnings();
            user.setEarnings(winnings);
            System.out.println("Current Winnings is now $" + winnings);
            System.out.println("--------------------------");
        } else {
            System.out.println("You take home zero dollars.");
        }
    }
}