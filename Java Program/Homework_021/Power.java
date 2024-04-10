import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the base X
        System.out.println("Enter X");
        double base = scanner.nextDouble();

        // Ask the user for the exponent N
        System.out.println("Enter N");
        int exponent = scanner.nextInt();

        if (exponent < 0) {
            System.out.println("N must be a positive integer.");
        } else {
            // Compute the power
            double result = 1.0;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }

            // Output the result
            System.out.println(base + " raised to the power " + exponent + " is: " + result);
        }

        scanner.close();
    }
}
