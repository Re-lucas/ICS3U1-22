import java.util.Scanner;
import java.util.Random;

public class RandomList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the size of the list:");
        int size = scanner.nextInt();

        System.out.println("Enter the lower bound of the range:");
        int lowerBound = scanner.nextInt();

        System.out.println("Enter the upper bound of the range:");
        int upperBound = scanner.nextInt();

        // Ensure the upper bound is greater than the lower bound
        if (upperBound < lowerBound) {
            upperBound = lowerBound + 1;
        }

        int[] randomList = new int[size];
        double sum = 0;

        // Generate random numbers and calculate the sum
        for (int i = 0; i < size; i++) {
            randomList[i] = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            sum += randomList[i];
        }

        double average = sum / size;
        int countLargerThanAverage = 0;


        /*       
        // Count numbers larger than the average
        for (int num : randomList) {
            if (num > average) {
                countLargerThanAverage++;
            }
        }
        */
        
        for (int i = 0 ; i < randomList.length; i++) {
            if (randomList[i] > average) {
                countLargerThanAverage++;
            }
        }

        // Output the results
        System.out.println("The average is: " + average);
        System.out.println("Number of integers larger than the average: " + countLargerThanAverage);

        scanner.close();
    }
}
