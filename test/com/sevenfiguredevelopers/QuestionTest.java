package com.sevenfiguredevelopers;

import com.sevenfiguredevelopers.controller.SevenFigureDeveloperApp;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class QuestionTest extends TestCase {

    private Question question;
    private QuestionDB db;

    @Before
    public void setUp() throws Exception {
        question = new Question();
        db = new QuestionDB();
    }

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