package com.sevenfiguredevelopers;

import com.apps.util.Prompter;

import java.util.Map;

public class Question {
    private int id;
    private Difficulty difficulty;
    private String questionWithChoice;
    private String answer;

    // ctor
    public Question() {
    }

    public Question(int id, Difficulty difficulty, String questionWithChoice, String answer) {
        this.id = id;
        this.difficulty = difficulty;
        this.questionWithChoice = questionWithChoice;
        this.answer = answer;
    }

    // business method
    public void askQuestions() {
        System.out.println(getQuestionWithChoice());
    }

    public boolean checkAnswer(String answer) {
        boolean isCorrect = false;

        if (this.getAnswer().equals(answer)) {
            System.out.println(this.getAnswer() + " is Correct!!!");
            System.out.println("This question was worth: " + this.getDifficulty().getDollarAmount());
            isCorrect = true;
        }
        else if (! this.getAnswer().equals(answer) ){
            System.out.println("Ouch! Good try but the correct answer is " + this.getAnswer());
        }
        return isCorrect;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionWithChoice() {
        return questionWithChoice;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "This question difficulty level is " + getDifficulty() + ".";
    }
}