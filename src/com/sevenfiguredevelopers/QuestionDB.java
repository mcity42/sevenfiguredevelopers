package com.sevenfiguredevelopers;

import com.sevenfiguredevelopers.controller.SevenFigureDeveloperApp;

import java.util.ArrayList;
import java.util.List;

public class QuestionDB  {

    private List<Question> questionDatabase = new ArrayList<>(List.of (
            // id     difficulty     question         answer
            new Question(1, Difficulty.EASY, "What is a class? \n A: the \"blueprint\" " +
                    "when creating objects. \n B. An integer \n C. size of variable \n D. constructor  " , "A"),
            new Question(2, Difficulty.EASY, "What is the lowest amount of constructors an object can have? " +
                    "\n A: 1 \n B: 0 \n C: 2 \n D: 3", "A"),
            new Question(3, Difficulty.EASY, "Which statement is not true in java language?\n" +
                    "\n" +
                    "(a) A public member of a class can be accessed in all the packages.\n" +
                    "(b) A private member of a class cannot be accessed by the methods of the same class.\n" +
                    "(c) A private member of a class cannot be accessed from its derived class.\n" +
                    "(d) A protected member of a class can be accessed from its derived class.\n",
                    "B"),
            new Question(4, Difficulty.EASY, "To prevent any method from overriding, we declare the method as,\n" +
                    "(a) static (b) const (c) final (d) abstract ",
                    "C"),
            new Question(7, Difficulty.MEDIUM, "An object is an instance of a _____ ? \n " +
                    "A: method \n B: thing \n C: class \n D: object", "C"),
            new Question(8, Difficulty.MEDIUM, "What is the result of this expression: 2 % 2 == 1 ? " +
                    "\n A: True \n B: False", "B"),
            new Question(9, Difficulty.MEDIUM, "What is printed by the following statement?\n" +
                    "System.out.print(“Hello,\\nworld!”);\n" +
                    "\n" +
                    "(a) Hello, \\nworld! \n" +
                    "(b) Hello, world!\n" +
                    "(c)\n" +
                    "(d) “Hello, \\nworld!”",
                    "C"),
            new Question(10, Difficulty.MEDIUM, "What is byte code in the context of Java?\n" +
                    "\n" +
                    "(a) The type of code generated by a Java compiler.\n" +
                    "(b) The type of code generated by a Java Virtual Machine.\n" +
                    "(c) It is another name for a Java source file.\n" +
                    "(d) It is the code written within the instance methods of a class.",
                    "A"),
            new Question(13, Difficulty.HARD, "Which collection doesn't allow duplicates ? \n A: Set \n B: HashMap \n C: ArrayList \n D: List", "A"),
            new Question(14, Difficulty.HARD, "Mark the incorrect statement from the following:\n" +
                    "\n" +
                    "(a) Java is not a language for internet programming.\n" +
                    "(b) In java it is not easy to write C-like so called procedural programs\n" +
                    "(c) In java language objects have to be manipulated\n" +
                    "(d) In java language error processing is built into the language", "D")
    ));

    public List<Question> getQuestionDatabase() {
        return questionDatabase;
    }
}