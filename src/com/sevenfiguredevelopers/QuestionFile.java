package com.sevenfiguredevelopers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


/**
 *  Read from file implementation class of the {@code QuestionBank}
 *  interface, implements the getAllQuestions method using a map
 *  generated from the file
 *
 * @author Malik City
 * @version 1.0
 */
public class QuestionFile implements QuestionBank{
    private Map<Integer, Question> qMap = loadQuestionsFromFile();

    /**
     * Loads Question objects from a file to be used in-game
     * @return map of {@code Question} id's and Question objects
     */
    private Map<Integer, Question> loadQuestionsFromFile() {
        Map<Integer, Question> answerMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("data/questions.csv")); //starts from module folder (running dir)
            for (String line : lines) {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                Difficulty difficulty = Difficulty.valueOf(tokens[1]);
                String questionAndChoice = tokens[2];
                String answer = tokens[3];
                Question newQuestion = new Question(id, difficulty, questionAndChoice, answer);
                answerMap.put(id, newQuestion);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return answerMap;
    }

    /**
     * @return shuffled list of Questions from the map generated from file
     * @see "Collections API Specification"
     */
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>(qMap.values());
        Collections.shuffle(questionList);
        return questionList;
    }
}
