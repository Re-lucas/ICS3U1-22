import java.util.Scanner;

public class CheckNumberPair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first integer:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second integer:");
        int num2 = scanner.nextInt();

        boolean result = checkNumbers(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }

    public static boolean checkNumbers(int a, int b) {
        return a == 15 || b == 15 || (a + b) == 15 || Math.abs(a - b) == 15;
    }
}
