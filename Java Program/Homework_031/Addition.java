import java.util.Scanner;
import java.util.Random;

public class Addition {
    public static void main(String[] args) {

        //Creat the two variable for us to use
        Scanner myScanner = new Scanner(System.in);
        Random random = new Random();

        //insect the two random number by random.nextInt(); and the braket inside indicates the range of random
        int num1 = random.nextInt(100); // Change the range as needed
        int num2 = random.nextInt(100);

        // the Answer
        int correctAnswer = num1 + num2;
        int userAnswer;

        System.out.println("What is the result of " + num1 + " + " + num2 + "?");

        do {
            System.out.print("Enter your answer: ");
            userAnswer = myScanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct! Well done.");
            } else {
                System.out.println("Incorrect. Try again!");
            }
        } while (userAnswer != correctAnswer);

        myScanner.close();
    }
}
