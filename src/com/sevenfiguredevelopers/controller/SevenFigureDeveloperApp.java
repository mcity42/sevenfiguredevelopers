package com.sevenfiguredevelopers.controller;

import com.apps.util.Prompter;
import com.sevenfiguredevelopers.Difficulty;
import com.sevenfiguredevelopers.Question;
import com.sevenfiguredevelopers.QuestionDB;
import com.sevenfiguredevelopers.User;

import java.util.*;
import java.util.Scanner;

public class SevenFigureDeveloperApp {
    private Boolean isPlaying = false;  // not playing yet
    Difficulty level;
    Question nextQuestion;
    QuestionDB questionDB = new QuestionDB();
    Prompter prompter = new Prompter(new Scanner(System.in));
    User user = new User();

    public void execute() {
        promptForName();   // get their name, set to user's name to input
        isPlaying = true;
        promptForDifficulty();
        askQuestion();
    }


    private void promptForName() {
        String input = prompter.prompt("Enter your name: ", "\\w+", "Invalid name"); // how to add '-' in here?
        user.setName(input);
    }

    private void promptForDifficulty() {
        int difficulty;
        String input = prompter.prompt("Select 1 for easy, 2 for intermediate, 3 for hard: ", "1|2|3", "Invalid selection");
        difficulty = Integer.parseInt(input);
        switch (difficulty) {
            case 1:
                level = Difficulty.EASY;
                break;
            case 2:
                level = Difficulty.MEDIUM;
                break;
            case 3:
                level = Difficulty.HARD;
        }
    }


    private void askQuestion() {
        if (level.equals(Difficulty.HARD)) {
            for (Question question : questionDB.getQuestionDatabase()) {
                if (isPlaying) {
                    nextQuestion = question;
                    nextQuestion.askQuestions();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
                }
            }
        }
        if (level.equals(Difficulty.MEDIUM)) {
            for (Question question : questionDB.getQuestionDatabase()) {
                if (isPlaying) {
                    nextQuestion = question;
                    nextQuestion.askQuestions();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
                }
            }
        }
        if (level.equals(Difficulty.EASY)) {
            for (Question question : questionDB.getQuestionDatabase()) {
                if (isPlaying) {
                    nextQuestion = question;
                    nextQuestion.askQuestions();
                    promptForAnswer(question);
                    showWinnings(question);
                    promptToContinue();
                }
            }
        }
    }


    private void promptForAnswer(Question question) {
        String input = prompter.prompt("Choose A, B, C, or D", "A|B|C|D|a|b|c|d", "Error, please enter A, B, C, or D");
        isPlaying = question.checkAnswer(input.toUpperCase(Locale.ROOT));
    }


    private void promptToContinue() {
        while (isPlaying) {
            String input = prompter.prompt("Choose 1 to continue or 2 to exit with earnings.", "1|2", "Error, please enter 1 or 2.");
            if (input.equals("1")) {
                break;
            } else if (input.equals("2")) {
                System.out.println("Great game you won: " + user.getEarnings());
                isPlaying = false;
            }
        }
    }

    private int showWinnings(Question question) {
        int winnings = question.getDifficulty().getDollarAmount() + user.getEarnings();
        user.setEarnings(winnings);
        return winnings;
    }

}