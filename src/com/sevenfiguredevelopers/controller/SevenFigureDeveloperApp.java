package com.sevenfiguredevelopers.controller;

import com.sevenfiguredevelopers.Question;
import com.sevenfiguredevelopers.QuestionDB;
import com.sevenfiguredevelopers.User;

import java.util.*;
import java.util.Scanner;

public class SevenFigureDeveloperApp {
    private Boolean isPlaying = false;  // not playing yet
    private int maxLevel = 15;    // default
    QuestionDB questionDB = new QuestionDB();

    private Scanner scanner = new Scanner(System.in);
    User user = new User();
// **populateQuestionsList here either with method or loop through a file we write**

    public void execute() {
        promptForName();   // get their name, set to user's name to input
        isPlaying = true;
        promptForDifficulty();
        findNextQuestion();
    }


    private void promptForName() {
        user.setName(null);
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Contestant, please enter your first name: ");
            String input = scanner.nextLine();
            // if regex check here for valid
            user.setName(input);
            isValid = true;
        }
    }

    private int promptForDifficulty() {
        int difficulty = 0;
        System.out.println("Press 1 for easy, 2 for intermediate, 3 for hard");
        difficulty = Integer.parseInt(scanner.nextLine());
        switch (difficulty) {
            case 1: maxLevel = 5;
                    break;
            case 2: maxLevel = 10;
                    break;
            case 3: maxLevel = 15;
        }
        return difficulty;
    }


    private Question findNextQuestion() {
        Question nextQuestion = null;
        while (isPlaying) {
            if (maxLevel == 15) {
                while (isPlaying) {
                    for (Question question : questionDB.getQuestionDatabase()) {
                        nextQuestion = question;
                        nextQuestion.askQuestions();
                        checkAnswer(question);
                    }
                }
            }
            else if (maxLevel == 10) {
                while (isPlaying && user.getCurrentLevel() < 11) {
                    for (Question question : questionDB.getQuestionDatabase()) {
                        nextQuestion = question;
                        nextQuestion.askQuestions();
                        checkAnswer(question);
                    }
                }
            }
            else if (maxLevel == 5) {
                while (isPlaying && user.getCurrentLevel() < 6) {
                    for (Question question : questionDB.getQuestionDatabase()) {
                        nextQuestion = question;
                        nextQuestion.askQuestions();
                        checkAnswer(question);
                    }
                }
            }
        }
        return nextQuestion;
    }


    private void checkAnswer(Question question) {
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Choose A, B, C, or D.");
            String input = scanner.nextLine();
            String answer = input.toUpperCase();
            if (answer == "A" || answer == "B" || answer == "C" || answer == "D") {
                isValid = true;
                if (question.getAnswer().equals(input)) {
                    System.out.println(question.getAnswer() + " is Correct!!!");
                    System.out.println("You won " + question.getDifficulty().getDollarAmount());
                    user.setEarnings(question.getDifficulty().getDollarAmount() + user.getEarnings());
                    user.setCurrentLevel(user.getCurrentLevel() + 1);
                }
                else {
                    isPlaying = false;
                    System.out.println("Ouch! Good try but the correct answer is " + question.getAnswer());
                }
            }
            else {
                System.out.println("Invalid choice. Please enter A, B, C, or D.");
            }
        }
    }
}