import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumAndDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter two integers
        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();

        // Close the scanner after reading input
        scanner.close();

        // Calculate sum and difference
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;

        // Write the results to the file "result.txt" using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            writer.write("The sum is " + sum + "\n");
            writer.write("The difference is " + difference);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
