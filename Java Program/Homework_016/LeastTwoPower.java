/*
	File Name: LeastTwoPower.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 28, 2024
	Description: 
*/

import java.util.Scanner;

public class LeastTwoPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int inputNumber = scanner.nextInt();

        int powerOfTwo = 1;
        while (powerOfTwo < inputNumber) {
            powerOfTwo *= 2;
        }

        System.out.println("The smallest power of two greater than or equal to " + inputNumber + " is " + powerOfTwo);

        scanner.close();
    }
}
