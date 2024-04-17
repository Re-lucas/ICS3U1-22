import java.util.Random;

public class TwoLargest {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();

        // Fill the array with random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // Random numbers between 0 and 99
        }

        // Find the two largest numbers
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        // Output the two largest numbers
        System.out.println("The array: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\nThe two largest elements are: " + largest + " and " + secondLargest);
    }
}
