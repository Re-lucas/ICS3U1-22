import java.util.Scanner;

public class CountConsecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of integers (terminate with 0):");

        int prevValue = scanner.nextInt();
        int currentValue;
        int consecutiveCount = 0;

        boolean sequenceEnded = false; // Flag to track if sequence has ended

        while (!sequenceEnded) {
            currentValue = scanner.nextInt();

            if (currentValue == 0) {
                sequenceEnded = true; // Terminate the sequence
            }

            if (!sequenceEnded && currentValue == prevValue) {
                consecutiveCount++;
            }

            prevValue = currentValue;
        }

        System.out.println("Number of consecutive equal values: " + consecutiveCount);

        scanner.close();
    }
}
