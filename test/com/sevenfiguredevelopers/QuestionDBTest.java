package com.sevenfiguredevelopers;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionDBTest extends TestCase {
    private QuestionDB questionDB;

    @Before
    public void setUp() {
        questionDB = new QuestionDB();
    }

    @Test
    public void testGetRandomFromDB_shouldReturnRightSize_whenSizeIsCalled() {
        int size = questionDB.getAllQuestions().size();
        assertEquals(15,size);
    }
}
