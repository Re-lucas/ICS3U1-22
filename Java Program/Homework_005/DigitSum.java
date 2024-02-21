/*
	File Name: DigitSum.java
	Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 20, 2024
	Description: Write a program that asks the user for a three-digit number, 
    finds the sum of the digits of the number, and then prints both the number and 
    its digit sum.
*/
import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int num;

        System.out.println("Please enter a three-digit number: ");
        num = myScanner.nextInt();

        // Extracting each digit
        int digit1 = num / 100;     // Hundreds digit
        int digit2 = (num / 10) % 10;  // Tens digit
        int digit3 = num % 10;      // Units digit

        int digitSum = digit1 + digit2 + digit3;

        System.out.println("The three-digit number is: " + num);
        System.out.println("Digit sum is: " + digitSum);

        myScanner.close();
    }
}
