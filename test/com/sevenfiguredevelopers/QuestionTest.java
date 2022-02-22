package com.sevenfiguredevelopers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionTest {
    private Question question;
    private QuestionDB db;

    @Before
    public void setUp() {
        question = new Question();
        db = new QuestionDB();
    }

    @Test
    public void testValidAnswerInput() {
    }

    @Test
    public void testAnswerInput_shouldReturnDifficulty_whenGetDifficultyIsCalled() {
            Difficulty currentDifficulty = question.getDifficulty();
            assertEquals(currentDifficulty,question.getDifficulty());
    }

    @Test
    public void testGetDifficultyCount_shouldReturnCount_whenEasyDifficultyCalled() {
        int count = 0;
        for(Question questions : db.getRandomFromDB()) {
                if (questions.getDifficulty().equals(Difficulty.EASY)) {
                    count++;
                }
        }
        assertEquals(6,count);
    }

    @Test
    public void testGetDifficultyCount_shouldReturnCount_whenMediumDifficultyCalled() {
        int count = 0;
        for(Question questions : db.getRandomFromDB()) {
            if (questions.getDifficulty().equals(Difficulty.MEDIUM)) {
                count++;
            }
        }
        assertEquals(6,count);
    }
}