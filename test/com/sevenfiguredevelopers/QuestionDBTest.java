package com.sevenfiguredevelopers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionDBTest {
    private QuestionDB questionDB;
    private QuestionFile questionFile;

    @Before
    public void setUp() {
        questionDB = new QuestionDB();
        questionFile = new QuestionFile();
    }

    @Test
    public void testGetAllQuestions_shouldReturnCorrectSize_whenCalledOnDB() {
        int size = questionDB.getAllQuestions().size();
        assertEquals(15,size);
    }

    @Test
    public void testGetAllQuestions_shouldReturnCorrectSize_whenCalledOnFile() {
        int size = questionFile.getAllQuestions().size();
        assertEquals(15, size);
    }
}
