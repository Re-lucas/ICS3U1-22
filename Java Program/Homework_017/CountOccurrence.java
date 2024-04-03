import java.util.Scanner;

public class CountOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a positive integer N
        System.out.print("Enter a positive integer N: ");
        int N = scanner.nextInt();

        // Prompt the user for a list of positive numbers
        System.out.println("Enter a list of positive numbers");
        System.out.println("(Enter -1 to indicate the end):");

        int count = 0; // Initialize occurrence count to 0
        int num; // Variable to store input number

        do {
            num = scanner.nextInt();
            if (num != -1) {
                // If the number is not -1, continue processing
                if (num == N) {
                    // If the number matches N, increment occurrence count
                    count++;
                }
            }
        } while (num != -1); // Continue the loop until -1 is entered

        // Print the result
        System.out.println(N + " occurs " + count + " times in the list.");

        // Close the scanner
        scanner.close();
    }
}
