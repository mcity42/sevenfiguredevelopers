package com.sevenfiguredevelopers;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuestionTest extends TestCase {
    private Question question;
    private QuestionDB db;

    @Before
    public void setUp() {
        question = new Question();
        db = new QuestionDB();
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

    @Test
    public void testGetDifficultyCount_shouldReturnCount_whenHardDifficultyCalled() {
        int count = 0;
        for (Question questions : db.getRandomFromDB()) {
            if (questions.getDifficulty().equals(Difficulty.HARD)) {
                count++;
            }
        }
        assertEquals(3,count);
    }

    @Test
    public void testCheckAnswer_shouldNotBeZero_whenAskedIfEqualsToA() {
        int count = 0;
            for (Question questions : db.getRandomFromDB()) {
                   if(questions.getAnswer().equals("A")) {
                       count++;
                   }
            }
        assertTrue(count != 0);
    }

    @Test
    public void testCheckAnswer_shouldNotBeZero_whenAskedIfEqualsToB() {
        int count = 0;
        for (Question questions : db.getRandomFromDB()) {
            if(questions.getAnswer().equals("B")) {
                count++;
            }
        }
        assertTrue(count != 0);
    }

    @Test
    public void testCheckAnswer_shouldNotBeZero_whenAskedIfEqualsToC() {
        int count = 0;
        for (Question questions : db.getRandomFromDB()) {
            if(questions.getAnswer().equals("C")) {
                count++;
            }
        }
        assertTrue(count != 0);
    }

    @Test
    public void testCheckAnswer_shouldNotBeZero_whenAskedIfEqualsToD() {
        int count = 0;
        for (Question questions : db.getRandomFromDB()) {
            if(questions.getAnswer().equals("D")) {
                count++;
            }
        }
        assertTrue(count != 0);
    }

    @Test
    public void testErrorMessage_shouldReturnErrorMessageAndFalse_whenInvalidInput() {
        for (Question question : db.getRandomFromDB()) {
            assertEquals(false,question.checkAnswer("!"));
            assertEquals(false,question.checkAnswer("1"));
            assertEquals(false,question.checkAnswer("E"));
        }
    }

}