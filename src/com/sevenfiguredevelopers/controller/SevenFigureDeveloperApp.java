package com.sevenfiguredevelopers.controller;

import com.sevenfiguredevelopers.Question;
import com.sevenfiguredevelopers.User;

import java.util.Scanner;

class SevenFigureDeveloperApp {
    private Boolean isPlaying = false;  // not playing yet
    private int maxLevel = 15;    // default
    private List<Question>() questionsList =new ArrayList<Question>(); //List of Questions
    private Scanner scanner = new Scanner(System.in);
    User user = new User();
// **populateQuestionsList here either with method or loop through a file we write**

    public void execute() {
        promptForName();   // get their name, set to user's name to input
        isPlaying = true;
        promptForDifficulty();
        findNextQuestion();
    }

//
//    promptForDifficulty();  // if input: 1 = easy, 2 = intermediate, 3 = hard
//    isPlaying = true;
//
//    While (isPlaying)  {
//        currentLevel++;
//
//
//        switch (promptForDifficulty())
//        case 1: maxLevel = 5; break;
//        case 2: maxLevel = 10; break;
//        case 3: maxLevel = 15; break;
//
//        // depending on difficulty, delete the rest after maxLevel
//        switch(maxLevel)
//        case 4: for (i = questionsList.size(), i >= maxLevel ; i--)
//            questionsList.remove(i);
//        case 9: for (i = questionsList.size(), i >= maxLevel ; i--)
//            questionsList.remove(i);
//        case 14: for (i = questionsList.size(), i >= maxLevel ; i--)
//            questionsList.remove(i);
//
//        // now iterate through list, Note the ID used for better sorting of object
//        For (Question question : questionsList) {
//            // use a stream inside a switch or if block
//            if (currentLevel == 1 || currrentLevel == 2) {
//                Question easyOne  =   questionsList.stream().filter(question ->
//                                question.getDiffculty().equals(Diffculty.EASY)
//                                        .map(question -> question.getQuestion())
//                                        .sorted(Comparator.comparing(Question::getID))
//                                        .limit(1)
//                                        .peek(question -> question.ask())
//                                        .collect(Collectors.toList())
//
//
//
//                        // repeat for INTERMEDIATE and HARD (2 more blocks).
//// Beyond 5 we don’t care which is asked really can else stream limit of 1 each by ID
//
//
//
//
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

    private int Difficulty() {
        int difficulty = 0;
        System.out.println("Press 1 for easy, 2 for intermediate, 3 for hard");
        String input = scanner.nextLine();
        switch (difficulty) {

        }
    }


    private Question findNextQuestion() {
        Question nextQuestion = null;
        while (isPlaying) {
            for (Question question : QuestionDatabase) {
                nextQuestion = question;
                nextQuestion.ask();
            }
        }
        return nextQuestion;
    }
}




















