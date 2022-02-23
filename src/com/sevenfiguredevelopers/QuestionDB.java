package com.sevenfiguredevelopers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuestionDB implements QuestionBank{
    private List<Question> questionDatabase = new ArrayList<>(List.of(
            // id     difficulty     question         answer
            new Question(1, Difficulty.EASY, "What is a class? \n (a) the \"blueprint\" " +
                    "when creating objects. \n (b) An integer \n (c) size of variable \n (d) constructor  ", "A"),
            new Question(2, Difficulty.EASY, "What is the lowest amount of constructors an object can have? " +
                    "\n (a) 1 \n (b) 0 \n (c) 2 \n (d) 3", "A"),
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
            new Question(5, Difficulty.MEDIUM, "An object is an instance of a _____ ? \n " +
                    "(a) method \n (b) thing \n (c) class \n (d) object", "C"),
            new Question(6, Difficulty.MEDIUM, " Which collection acts like a table of key-value pairs? " +
                    "\n (a) List (b) Map (c) ArrayList (d) int", "B"),
            new Question(7, Difficulty.MEDIUM, "What is printed by the following statement?\n" +
                    "System.out.print(“Hello,\\nworld!”);\n" +
                    "\n" +
                    "(a) Hello, \\nworld! \n" +
                    "(b) Hello, world!\n" +
                    "(c)\n" +
                    "(d) “Hello, \\nworld!”",
                    "C"),
            new Question(8, Difficulty.MEDIUM, "What is byte code in the context of Java?\n" +
                    "\n" +
                    "(a) The type of code generated by a Java compiler.\n" +
                    "(b) The type of code generated by a Java Virtual Machine.\n" +
                    "(c) It is another name for a Java source file.\n" +
                    "(d) It is the code written within the instance methods of a class.",
                    "A"),
            new Question(9, Difficulty.HARD, "Which collection doesn't allow duplicates ? \n (a) Set \n (b) HashMap \n (c) ArrayList \n (d) List", "A"),
            new Question(10, Difficulty.HARD, "Mark the incorrect statement from the following:\n" +
                    "\n" +
                    "(a) Java is not a language for internet programming.\n" +
                    "(b) In java it is not easy to write C-like so called procedural programs\n" +
                    "(c) In java language objects have to be manipulated\n" +
                    "(d) In java language error processing is built into the language", "D"),
            new Question(11, Difficulty.EASY, "Which is the characteristic of an immutable class? \n (a) Objects of the class cannot change content after creation \n" +
                    " (b) Objects of the class cannot be parsed \n (c) The class has all static methods \n (d) The class has all static final fields", "A"),
            new Question(12, Difficulty.EASY, "Which of the following is not an interface?  \n (a) Map \n" +
                    " (b) SortedMap \n (c) ArrayList \n (d) Collection", "C"),
            new Question(13, Difficulty.MEDIUM, "What was the original name of Java? \n (a) WebC \n" +
                    " (b) Oak \n (c) C- \n (d) SunLang", "B"),
            new Question(14, Difficulty.MEDIUM, "What is the output of: System.out.println(1+2+” = “+1+2); ?  \n (a) 12=3 \n" +
                    " (b) 3=3 \n (c) 12=12 \n (d) 3=12", "D"),
            new Question(15, Difficulty.HARD, "Who invented Java on accident? \n (a) Alan Turing \n" +
                    " (b) Dennis Ritchie \n (c) James Gosling \n (d) Bjarne Stroustroup", "C")
    ));

    public List<Question> getAllQuestions() {
        Collections.shuffle(questionDatabase);
        return questionDatabase;
    }
}