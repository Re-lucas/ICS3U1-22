import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[6];

        // a) Declare an array of 6 doubles - already declared above

        // b) Read in a list of values from the user
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        // c) Print the values in reverse order
        System.out.println("Values in reverse order:");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }

        // d) Add 10% to each value in the array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] += numbers[i] * 0.10;
        }

        // e) Print all the values that are over 50
        System.out.println("Values over 50:");
        for (double number : numbers) {
            if (number > 50) {
                System.out.println(number);
            }
        }

        scanner.close();
    }
}
