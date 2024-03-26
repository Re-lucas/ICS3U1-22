/** 
	File Name: CheckPositive.java
	Name: I. Lam
	Class: ICS3U1
	Date: March 8, 2023
	Description: This program prompts user for a number and determines
   if it is positive.
   It demonstrates the use of a simple if - else structure.
*/

import java.util.Scanner;

public class CheckPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println((int) 'A');
        System.out.print("Enter an integer:  ");
        num = sc.nextInt();

        // check if the number is greater than 0
        if (num > 0) {
            // num is > 0
            System.out.println("Positive number.");
        } else {
            // num is not > 0
            System.out.println("Not a positive number.");
        }

        sc.close();
    }
}
