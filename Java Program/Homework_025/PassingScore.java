// PassingScore.java

import java.util.Scanner;

public class PassingScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare and create two arrays of size 15
        double[] score = new double[15];
        boolean[] passing = new boolean[15];

        // Prompt user for 15 scores and fill in the corresponding array
        for (int i = 0; i < 15; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            score[i] = scanner.nextDouble();
        }

        // Set entry in 'passing' to true if parallel value of 'score' is greater than 60
        for (int i = 0; i < 15; i++) {
            passing[i] = score[i] > 60;
        }

        // Output number of entries with passing score
        int passingCount = 0;
        for (boolean isPassing : passing) {
            if (isPassing) {
                passingCount++;
            }
        }
        System.out.println("Number of passing scores: " + passingCount);

        scanner.close();
    }
}
