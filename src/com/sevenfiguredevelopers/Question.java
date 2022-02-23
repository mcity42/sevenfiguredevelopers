package com.sevenfiguredevelopers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Question {
    private int id;
    private Difficulty difficulty;
    private String questionWithChoice;
    private String answer;
    private String sorry;

    public Question() {
    }

    public Question(int id, Difficulty difficulty, String questionWithChoice, String answer) {
        this.id = id;
        this.difficulty = difficulty;
        this.questionWithChoice = questionWithChoice;
        this.answer = answer;
        try {
            sorry = Files.readString(Path.of("data/sorry.txt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ask() {
        String questionAndChoice = getQuestionWithChoice();
        String[] parts = questionAndChoice.split("\\(");
        String question = parts[0];
        String choice1 = parts[1];
        String choice2 = parts[2];
        String choice3 = parts[3];
        String choice4 = parts[4];
        System.out.println(question + "\n" + choice1 + "\n" + choice2 + "\n" + choice3 + "\n" + choice4);
    }

    public boolean checkAnswer(String answer) {
        boolean isCorrect = false;
        if (this.getAnswer().equals(answer)) {
            System.out.println("\n--------------------");
            System.out.println(this.getAnswer() + " is Correct!!!");
            System.out.println("This question was worth: $" + this.getDifficulty().getDollarAmount());
            isCorrect = true;
        } else if (!(this.getAnswer().equals(answer))) {
            System.out.println("\nOuch! Good try but the correct answer is " + this.getAnswer() + "\n");
            System.out.println(sorry);
            System.out.println();
        }
        return isCorrect;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getQuestionWithChoice() {
        return questionWithChoice;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return getQuestionWithChoice();
    }
}