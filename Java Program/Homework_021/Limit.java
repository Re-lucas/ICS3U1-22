import java.util.Scanner;

public class Limit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the value of N
        System.out.print("Enter N: ");
        int N = scanner.nextInt();

        double sum = 0.0;

        // Compute the sum
        for (int i = 1; i <= N; i++) {
            sum += 1.0 / i;
        }

        // Output the sum
        System.out.println("Sum is: " + sum);

        scanner.close();
    }
}
