package com.sevenfiguredevelopers.controller;

import com.apps.util.Prompter;
import com.sevenfiguredevelopers.Question;
import com.sevenfiguredevelopers.QuestionBank;
import com.sevenfiguredevelopers.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SevenFigureDeveloperApp {
    private boolean isPlaying = true;
    private int maxLevel = 15;
    private User user = new User();
    private int currentLevel = user.getCurrentLevel();
    private QuestionBank questionBank = QuestionBank.getInstance();
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private static String welcome;
    private static String congrats;


    public SevenFigureDeveloperApp() {
        try {
            welcome = Files.readString(Path.of("data/welcome.txt"));
            congrats = Files.readString(Path.of("data/congrats.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void execute() {
        System.out.println(welcome);
        System.out.println();
        promptForName();
        promptForDifficulty();
        play();
    }

    private void promptForName() {
        user.setName(null);
        boolean isValid = false;
        String input = prompter.prompt("Enter your name: ");
        if (input.trim().equals("")) {
            input = "Player";
        }
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

    private void play() {
        for (int i = 0; i < maxLevel; i++) {
            List<Question> questions = questionBank.getAllQuestions();
            for (Question question : questions) {
                if (isPlaying) {
                    if (currentLevel > (maxLevel - 1) && (user.getEarnings() >= 1_000_000)) {
                        System.out.println("Your total is: $" + user.getEarnings() + "!! You are a Seven Figure Developer!!");
                        System.out.println(congrats);
                        System.out.println("Please restart.");
                        isPlaying = false;
                        break;
                    }
                    question.ask();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
                }
            }
        }
    }

    private void promptForAnswer(Question question) {
        String input = prompter.prompt("Choose A, B, C, or D: ", "A|B|C|D|a|b|c|d", "Error, please enter A, B, C, or D");
        isPlaying = question.checkAnswer(input.toUpperCase());
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