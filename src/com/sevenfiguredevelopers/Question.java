package com.sevenfiguredevelopers;

public class Question {
    private int id;
    private Difficulty difficulty;
    private String questionWithChoice;
    private String answer;

    public Question(int id, Difficulty difficulty, String questionWithChoice, String answer) {
        this.id = id;
        this.difficulty = difficulty;
        this.questionWithChoice = questionWithChoice;
        this.answer = answer;
    }

    public String askQuestion() { //TODO: never used return
        System.out.println(getQuestionWithChoice());
        return getQuestionWithChoice();
    }

    public boolean checkAnswer(String answer) {
        boolean isCorrect = false;
        if (this.getAnswer().equals(answer)) {
            System.out.println("\n--------------------");
            System.out.println(this.getAnswer() + " is Correct!!!");
            System.out.println("This question was worth: $" + this.getDifficulty().getDollarAmount());
            isCorrect = true;
        } else if (!(this.getAnswer().equals(answer))) {
            System.out.println("\nOuch! Good try but the correct answer is " + this.getAnswer());
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
        return "This question difficulty level is " + getDifficulty() + ".";
    }
}