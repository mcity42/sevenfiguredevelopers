package com.sevenfiguredevelopers;

import java.util.List;

public interface QuestionBank {

    // static factory method
    public static QuestionBank getInstance() {
        //return new QuestionDB();
        return new QuestionFile();
    }


    public List<Question> getAllQuestions();
}
