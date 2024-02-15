/*
	File Name: Average.java
	Name: Lcuas Wu
   	Class: ICS3U1-01
	Date: Feb 15, 2024
	Description: a Write a program that reads three double values and computes their average. (Don’t worry about rounding at this point).
*/

import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        Double firstNumDouble;
        Double secondNumDouble;
        Double thirdNumDouble;

        System.out.println("Enter three double values and i will computes their average");

        System.out.print("Enter your first number:");
        firstNumDouble = myScanner.nextDouble(); 
        myScanner.nextLine();

        System.out.print("Enter your second number: ");
        secondNumDouble = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.print("Enter your third number: ");
        thirdNumDouble = myScanner.nextDouble();
        myScanner.nextLine();

        Double avgDouble = (firstNumDouble + secondNumDouble + thirdNumDouble) / 3;
        System.out.println("Your avg is: " + avgDouble);

        myScanner.close();
    }
    
}
