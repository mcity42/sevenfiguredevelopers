package com.sevenfiguredevelopers;

import java.util.Map;

public class EasyQuestion extends Question {
    // attributes
    private int dollarAmount = 150_000;
    private Difficulty easyStage = Difficulty.EASY;

    public EasyQuestion(int id, Difficulty difficulty, String questionWithChoice, String answer) {
        super(id, difficulty, questionWithChoice, answer);
    }

    @Override
    public String askQuestions() {
        return super.askQuestions();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public Difficulty getDifficulty() {
        return super.getDifficulty();
    }

    @Override
    public String getQuestionWithChoice() {
        return super.getQuestionWithChoice();
    }

    @Override
    public String getAnswer() {
        return super.getAnswer();
    }

    @Override
    public Map<String, String> getDatabaseQA() {
        return super.getDatabaseQA();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
