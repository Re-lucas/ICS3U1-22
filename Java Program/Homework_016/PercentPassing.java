/*
	File Name: PercentPassing.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 28, 2024
	Description: 
*/


import java.util.Scanner;

public class PercentPassing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score;
        int totalScores = 0;
        int above70 = 0;

        System.out.println("Enter scores (negative score to terminate):");

        do {
            score = scanner.nextInt();
            if (score >= 0) {
                totalScores++;
                if (score > 70) {
                    above70++;
                }
            }
        } while (score >= 0);

        double percentage = (double) above70 / totalScores * 100;
        System.out.println("Percentage of scores above 70: " + percentage + "%");

        scanner.close();
    }
}
