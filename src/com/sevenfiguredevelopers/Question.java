package com.sevenfiguredevelopers;

import java.util.Map;

public class Question {
    private int id;
    private Difficulty difficulty;
    private String questionWithChoice;
    private String answer;
    Map<String, String> databaseQA;

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
    public String askQuestions() {
        return getQuestionWithChoice();
    }

    public Boolean checkAnswer(String userAnswer) {
        return getAnswer().equals(userAnswer);
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

    public Map<String, String> getDatabaseQA() {
        return databaseQA;
    }

    @Override
    public String toString() {
        return "This question difficulty level is " + getDifficulty() + ".";
    }
}