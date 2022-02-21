package com.sevenfiguredevelopers;

import java.util.Map;

public class Question {
    private int id;
    private Difficulty difficulty;
    private String questionWithChoice;
    private String answer;
    Map<String, String> databaseQA;

    // ctor
    public Question(int id, Difficulty difficulty, String questionWithChoice, String answer) {
        this.id = id;
        this.difficulty = difficulty;
        this.questionWithChoice = questionWithChoice;
        this.answer = answer;
    }

    // business class
    public String askQuestions() {
        return getQuestionWithChoice();
    }

    // getter and setter
    public int getId() {
        return id;
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

    public Map<String, String> getDatabaseQA() {
        return databaseQA;
    }

    @Override
    public String toString() {
        return "Question{" +
                ", questionWithChoice='" + questionWithChoice + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
