package com.sevenfiguredevelopers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuestionFile {
    private Map<Integer, Question> qMap = loadQuestionsFromFile();

    // Load the Question objects from file
    public Map<Integer, Question> loadQuestionsFromFile() {
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

    public List<Question> getRandomFromFile() {
        List<Question> questionList = new ArrayList<>(qMap.values());
        Collections.shuffle(questionList);
        return questionList;
    }
}
