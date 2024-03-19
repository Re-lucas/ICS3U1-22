/*
	File Name: Test.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description: Write a program that asks teacher to enter a test mark, then 
    outputs if the mark is above range (over 100), below range (under 0), passing, 
    or failing. Assume passing mark is 50
*/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a test mark:");
        int mark = scanner.nextInt();

        if (mark > 100) {
            System.out.println("The mark is above range (over 100).");
        } else if (mark < 0) {
            System.out.println("The mark is below range (under 0).");
        } else if (mark >= 50) {
            System.out.println("Passing.");
        } else {
            System.out.println("Failing.");

            scanner.close();
        }
    }
}
