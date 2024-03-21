/*
	File Name: Quiz.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 21, 2024
	Description: 
*/

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quiz questions
        String[] questions = {
            "1. What is the purpose of a decision structure in programming?",
            "2. Which statement is used to implement a single alternative decision structure in Java?",
            "3. What is the correct syntax for an if-else statement in Java?",
            "4. What is the role of the default case in a switch statement?",
            "5. When should you use a switch statement instead of multiple if-else statements?"
        };

        // Array of arrays containing choices for each question
        String[][] choices = {
            {"A. To execute a set of statements conditionally based on the value of a boolean expression.",
             "B. To repeat a set of statements multiple times until a condition becomes false.",
             "C. To define a block of code that is executed only if a condition is true.",
             "D. To print a message to the console."},
            {"A. if-else",
             "B. switch",
             "C. while",
             "D. for"},
            {"A. if (condition) { // code block } else { // code block }",
             "B. if (condition) then { // code block } else { // code block }",
             "C. if (condition) then ( // code block ) else ( // code block )",
             "D. if (condition) { // code block }"},
            {"A. It is executed when none of the case values match the value of the expression.",
             "B. It is optional and can be omitted.",
             "C. It is executed if no other cases match and the break statement is used.",
             "D. It is used to define the default behavior of the switch statement."},
            {"A. When comparing a single variable against multiple values.",
             "B. When comparing multiple variables against multiple values.",
             "C. When the conditions involve complex boolean expressions.",
             "D. When there are only two possible outcomes."}
        };

        // Array of correct answers for each question
        String[] correctAnswers = {"A", "A", "D", "A", "A"};

        // Quiz loop
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String choice : choices[i]) {
                System.out.println(choice);
            }
            System.out.print("Enter your answer: ");
            String answer = scanner.next().toUpperCase();

            if (answer.equals(correctAnswers[i])) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswers[i] + "\n");
            }
        }

        // Display quiz score
        System.out.println("Quiz completed! Your score: " + score + "/" + questions.length);

        scanner.close();
    }
}
