import java.util.Scanner;

public class AllArrays2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize an array of size 14
        int[] originalArray = new int[14];

        // Ask user to input values for the array
        System.out.println("Enter " + originalArray.length + " integers:");
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = scanner.nextInt();
        }

        // First version: Using two arrays
        int[] reversedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        // Print the content of the reversed array
        System.out.println("Reversed array (using two arrays):");
        for (int value : reversedArray) {
            System.out.print(value + " ");
        }
        System.out.println(); // Print a newline

        // Second version: Reversing the original array in-place
        for (int i = 0; i < originalArray.length / 2; i++) {
            int temp = originalArray[i];
            originalArray[i] = originalArray[originalArray.length - 1 - i];
            originalArray[originalArray.length - 1 - i] = temp;
        }

        // Print the content of the reversed original array
        System.out.println("Reversed array (in-place):");
        for (int value : originalArray) {
            System.out.print(value + " ");
        }
        System.out.println(); // Print a newline

        scanner.close();
    }
}
