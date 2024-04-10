import java.util.Scanner;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evenCount = 0;
        int num;

        System.out.print("Enter an integer: ");
        num = scanner.nextInt();

        while (num > 0) {
            if (num % 2 == 0) {
                evenCount++; // Increment even count if the number is even
            }

            System.out.print("Enter an integer: ");
            num = scanner.nextInt();
        }

        System.out.println("You have entered " + evenCount + " even numbers.");

        scanner.close();
    }
}
