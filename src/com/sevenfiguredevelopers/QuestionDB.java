package com.sevenfiguredevelopers;

import java.util.ArrayList;
import java.util.List;

public class QuestionDB {

    private List<Question> questionDatabase = new ArrayList<>(List.of (
                        // id     difficulty     question         answer
            new Question(1, Difficulty.EASY, "What is a class? \n A: the \"blueprint\" " +
                    "when creating objects. \n B. An integer \n C. size of variable \n D. constructor  " , "A"),
            new Question(2, Difficulty.EASY, "What is the lowest amount of constructors an object can have? " +
                    "\n A: 1 \n B: 0 \n C: 2 \n D: 3", "B"),
            new Question(7, Difficulty.MEDIUM, "An object is an instance of a _____ ? \n " +
                    "A: method \n B: thing \n C: class \n D: object", "C"),
            new Question(8, Difficulty.MEDIUM, "What is the result of this expression: 2 % 2 == 1 ? " +
                    "\n A: True \n B: False", "B"),
            new Question(13, Difficulty.HARD, "Which collection doesn't allow duplicates ? \n A: Set \n B: HashMap \n C: ArrayList \n D: List", "A")



    ));

}
