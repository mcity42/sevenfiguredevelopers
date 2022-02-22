package com.sevenfiguredevelopers;

import com.sevenfiguredevelopers.controller.SevenFigureDeveloperApp;
import junit.framework.TestCase;

public class QuestionTest extends TestCase {

    @Override
    public void setUp() throws Exception {
        SevenFigureDeveloperApp app = new SevenFigureDeveloperApp();
        app.execute();
    }

    public void testValidAnswerInput() {
    }

    public void testAnswerInput_shouldReturnErrorMessage_whenNotCorrectAnswerChoice() {
        //assertTrue(isPlaying,
    }


}