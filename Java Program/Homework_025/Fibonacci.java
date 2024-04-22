import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the first two numbers of the Fibonacci sequence from the user
        System.out.print("Enter 'a': ");
        int a = scanner.nextInt();
        
        System.out.print("Enter 'b': ");
        int b = scanner.nextInt();
        
        // Get the number of terms in the sequence from the user
        System.out.print("Enter number of terms: ");
        int n = scanner.nextInt();
        
        // Create an array to store the Fibonacci sequence
        int[] fibonacciSequence = new int[n];
        
        // Initialize the first two terms
        fibonacciSequence[0] = a;
        fibonacciSequence[1] = b;
        
        // Calculate the rest of the Fibonacci sequence
        for (int i = 2; i < n; i++) {
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }
        
        // Output the Fibonacci sequence
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSequence[i]);
            if (i < n - 1) {
                System.out.print(",");
            }
        }
    }
}
