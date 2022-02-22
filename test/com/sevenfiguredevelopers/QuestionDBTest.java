package com.sevenfiguredevelopers;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionDBTest extends TestCase {

    private QuestionDB questionDB;
    @Before
    public void setUp() throws Exception {
        questionDB = new QuestionDB();
    }

    @Test
    public void testGetRandomFromDB_shouldReturnSize_whenSizeIsCalled() {
        int size = questionDB.getRandomFromDB().size();
        assertEquals(15,size);
    }
}
