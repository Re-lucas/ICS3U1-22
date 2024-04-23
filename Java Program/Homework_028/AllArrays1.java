import java.util.Scanner;

public class AllArrays1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task a: Ask user to enter an integer n, then declare an array of integer of size n
        System.out.print("Enter an integer for the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Task b: Initialize all elements of the array to one
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        // Task c: Ask user to enter n integers, and fill the arrays with these integers in order
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        // Task d: Switch the values at either end of the array
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;

        // Task e: Change any negative values to positive values (of the same magnitude)
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = -array[i];
            }
        }

        // Task f: Set the variable sampleSum to the sum of the values of all the elements
        int sampleSum = 0;
        for (int value : array) {
            sampleSum += value;
        }

        // Task g: Print all the even numbers in the array
        System.out.println("Even numbers in the array:");
        for (int value : array) {
            if (value % 2 == 0) {
                System.out.println(value);
            }
        }

        scanner.close();
    }
}
