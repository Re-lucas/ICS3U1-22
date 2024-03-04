/*
	File Name:Login.java 
	Name: Lucas Wu
   Class: ICS3U1-01
	Date: Mar 4, 2024
	Description: The example for while, if else statement.
*/

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        final int user_password = 348905555;
        int password_check;
        int attempts = 3; // Number of allowed login attempts

        while (attempts > 0) {
            System.out.print("Please enter your password: ");
            password_check = myScanner.nextInt();

            if (password_check == user_password) {
                System.out.println("Login Successfully");
                break; // Exit the loop if the password is correct
            } else {
                System.out.println("Login Unsuccessfully. " + (--attempts) + " attempts remaining.");
            }
        }

        if (attempts == 0) {
            System.out.println("Too many unsuccessful attempts. Account locked.");
        }

        myScanner.close();
    }
}
