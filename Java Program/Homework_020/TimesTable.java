import java.util.Scanner;

public class TimesTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();

        // Print the n-times table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int result = i * j;
                System.out.printf("%d X %d = %d%n", i, j, result);
            }
        }

        scanner.close();
    }
}
