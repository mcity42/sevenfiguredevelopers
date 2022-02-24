package com.sevenfiguredevelopers;

import java.util.List;



/**
 *  Interface that abstracts the two different implementations
 *  of {@code Question} inventory management
 */
public interface QuestionBank {
    /**
     * static facory method
     * @return new instance of a QuestionBank which
     * now uses the QuestionFile implementation
     */
    public static QuestionBank getInstance() {
        //return new QuestionDB();
        return new QuestionFile();
    }

    /**
     * @return list of Question objects from the
     * implemented source
     */
    public List<Question> getAllQuestions();
}
