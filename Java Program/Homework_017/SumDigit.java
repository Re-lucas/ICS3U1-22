import java.util.Scanner;

public class SumDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Convert the integer to a positive value (if negative)
        number = Math.abs(number);

        // Calculate the sum of digits
        
        /*
        First, we initialize a variable sum to zero to store the sum of the numbers.
        Then, we enter a while loop, provided that number is greater than zero.
        In the loop, we use the modulo operator % to get the last digit of number (the single digit).
        We add this number to the sum.
        Next, we divide number by 10, which removes the last digit so that the next loop deals with the next digit.
        The loop continues until number goes to zero, at which point we have processed all the digits.
        Finally, we print out the sum of all the digits we've calculated.
        */
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }

        // Print the sum of digits
        System.out.println("Sum of digits: " + sum);

        // Close the scanner
        scanner.close();
    }
}
