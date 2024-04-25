import java.util.Scanner;

public class Array1DOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        // Input 10 integers
        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Check if all integers are odd or even
        boolean allOdd = true;
        boolean allEven = true;
        for (int num : numbers) {
            if (num % 2 == 0) {
                allOdd = false;
            } else {
                allEven = false;
            }
        }

        // Output the result
        if (allOdd) {
            System.out.println("All 10 integers are odd.");
        } else if (allEven) {
            System.out.println("All 10 integers are even.");
        } else {
            System.out.println("The integers are a mix of odd and even.");
        }

        scanner.close();
    }
}
