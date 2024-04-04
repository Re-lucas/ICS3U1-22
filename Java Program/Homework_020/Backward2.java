import java.util.Scanner;

public class Backward2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a number between 50 and 100
        System.out.print("Enter a number between 50 and 100: ");
        int stopNumber = scanner.nextInt();

        // Validate the input
        if (stopNumber < 50 || stopNumber > 100) {
            System.out.println("Invalid input. Please enter a number between 50 and 100.");
        }

        // Start the count from 100
        for (int count = 100; count >= stopNumber; count -= 5) {
            System.out.print(count + " ");
        }

        scanner.close();
    }
}
