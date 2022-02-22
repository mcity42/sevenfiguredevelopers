package com.sevenfiguredevelopers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionDBTest {
    private QuestionDB questionDB;

    @Before
    public void setUp() {
        questionDB = new QuestionDB();
    }

    @Test
    public void testGetRandomFromDB_shouldReturnRightSize_whenSizeIsCalled() {
        int size = questionDB.getRandomFromDB().size();
        assertEquals(15,size);
    }
}
