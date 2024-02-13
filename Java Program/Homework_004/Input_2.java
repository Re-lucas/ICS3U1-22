/** 
	File Name: Input_1.java 
	Name: Lucas Wu
   Class: ICS3U1-01
	Date: Feb 13, 2024
	Description: Write a program that asks the user for his/her and then output “Hello <name>”.
*/

import java.util.Scanner;

public class Input_2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter your last name: ");
        String name_last = myScanner.nextLine();

        System.out.println("Enter your first name: "); 
        String name_first = myScanner.nextLine();

        System.out.println("Hello, nice to meet you, " + name_last + " " + name_first + "! Welcome to the Java world.");

        myScanner.close();
    }
}

