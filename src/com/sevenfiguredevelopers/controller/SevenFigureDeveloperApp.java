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
    User user = new User();
    private int currentLevel = user.getCurrentLevel();
    QuestionDB questionDB = new QuestionDB();
    Prompter prompter = new Prompter(new Scanner(System.in));



    public void execute() {
        System.out.println(" __        ___            __        __          _          _           _                   \n" +
                " \\ \\      / / |__   ___   \\ \\      / /_ _ _ __ | |_ ___   | |_ ___    | |__   ___     __ _ \n" +
                "  \\ \\ /\\ / /| '_ \\ / _ \\   \\ \\ /\\ / / _` | '_ \\| __/ __|  | __/ _ \\   | '_ \\ / _ \\   / _` |\n" +
                "   \\ V  V / | | | | (_) |   \\ V  V / (_| | | | | |_\\__ \\  | || (_) |  | |_) |  __/  | (_| |\n" +
                "    \\_/\\_/  |_|_|_|\\___/     \\_/\\_/ \\__,_|_| |_|\\__|___/   \\__\\___/   |_.__/ \\___|   \\__,_|\n" +
                "   |___  | |  ___(_) __ _ _   _ _ __ ___    |  _ \\  _____   _____| | ___  _ __   ___ _ __  \n" +
                "      / /  | |_  | |/ _` | | | | '__/ _ \\   | | | |/ _ \\ \\ / / _ \\ |/ _ \\| '_ \\ / _ \\ '__| \n" +
                "     / /   |  _| | | (_| | |_| | | |  __/   | |_| |  __/\\ V /  __/ | (_) | |_) |  __/ |    \n" +
                "    /_/    |_|   |_|\\__, |\\__,_|_|  \\___|   |____/ \\___| \\_/ \\___|_|\\___/| .__/ \\___|_|    \n" +
                "                    |___/                                                |_|               ");
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
            for (Question question : questionDB.getRandomFromDB()) {
                if (isPlaying) {
                    if (currentLevel > (maxLevel - 1) && (user.getEarnings() >= 1_000_000)) {
                        System.out.println("Your total is: $" + user.getEarnings() + "!! You are a Seven Figure Developer!!");
                        System.out.println("   _     _    _____    _____ _                         ____                 _                         _   _    _     _  \n" +
                                "  | |   | |  |___  |  |  ___(_) __ _ _   _ _ __ ___   |  _ \\  _____   _____| | ___  _ __   ___ _ __  | | | |  | |   | | \n" +
                                " / __) / __)    / /   | |_  | |/ _` | | | | '__/ _ \\  | | | |/ _ \\ \\ / / _ \\ |/ _ \\| '_ \\ / _ \\ '__| | | | | / __) / __)\n" +
                                " \\__ \\ \\__ \\   / /    |  _| | | (_| | |_| | | |  __/  | |_| |  __/\\ V /  __/ | (_) | |_) |  __/ |    |_| |_| \\__ \\ \\__ \\\n" +
                                " (   / (   /  /_/     |_|   |_|\\__, |\\__,_|_|  \\___|  |____/ \\___| \\_/ \\___|_|\\___/| .__/ \\___|_|    (_) (_) (   / (   /\n" +
                                "  |_|   |_|                    |___/                                               |_|                        |_|   |_| ");
                        System.out.println("Please restart.");
                        isPlaying = false;
                        break;
                    }
                    question.askQuestion();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
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
            if (input.equals("2")) {
                System.out.println("Great game " + user.getName() + ", you won $" + user.getEarnings() + " and made it pass level " + user.getCurrentLevel());
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
            user.setCurrentLevel(currentLevel++);
            System.out.println(user);
            System.out.println("--------------------------");
        } else {
            System.out.println("You take home zero dollars.");
        }
    }
}