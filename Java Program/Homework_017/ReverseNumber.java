import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Convert the integer to a positive value (if negative)
        number = Math.abs(number);

        // Convert the integer to a string to extract individual digits
        String numberStr = Integer.toString(number);

        // Print the digits in reverse order
        System.out.print("Digits in reverse order: ");
        for (int i = numberStr.length() - 1; i >= 0; i--) {
            System.out.print(numberStr.charAt(i) + " ");
        }

        // Close the scanner
        scanner.close();
    }
}
