/** 
	File Name: Input_3.java
	Name: Lucas Wu
   Class: ICS3U1-01
	Date: Feb 13,2024
	Description: The input template of string , double int 
*/

import java.util.Scanner;

public class Input_3 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner myObj = new Scanner(System.in);

        // Prompt the user to enter their first name
        System.out.println("Enter your first name");
        String name_first = myObj.nextLine(); // Read the user's first name

        // Prompt the user to enter their last name
        System.out.println("Enter your last name");
        String name_last = myObj.nextLine(); // Read the user's last name

        // Declare a variable to store the user's age
        int user_age;
        // Prompt the user to enter their age
        System.out.println("Enter your age");
        user_age = myObj.nextInt(); // Read the user's age

        // Display the user's full name
        System.out.println("Your Name is: " + name_first + " " + name_last);
        // Display the user's age
        System.out.println("Your age is: " + user_age);

        myObj.close();
    }
}