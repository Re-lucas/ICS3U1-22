import java.util.Scanner;

public class NumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many integers will be added
        System.out.print("How many integers will be added? ");
        int count = scanner.nextInt();

        int sum = 0;

        // Prompt the user for each number and calculate the sum
        for (int i = 0; i < count; i++) {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            sum += num;
        }

        // Output the sum
        System.out.println("The sum is " + sum);

        scanner.close();
    }
}
