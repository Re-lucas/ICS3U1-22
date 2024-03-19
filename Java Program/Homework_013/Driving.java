/*
	File Name: Driving.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description: A certain Traffic Department rules that people may only drive if 
    they are 18 or older, but not more than 75 years old. Input a person’s age. If 
    they are less than 18, display the age and “Too young to drive”. If they are 
    over 75, display the age and “Sorry you are over the legal age limit for driving”. 
    If they fall in the correct range, display the age and a message stating “Age 
    OK. Have you got a driver’s licence?”
*/

import java.util.Scanner;

public class Driving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your age:");
        int age = scanner.nextInt();

        if (age < 18) {
            System.out.println(age + " - Too young to drive.");
        } else if (age > 75) {
            System.out.println(age + " - Sorry you are over the legal age limit for driving.");
        } else {
            System.out.println(age + " - Age OK. Have you got a driver’s licence?");
        }

        scanner.close();
    }
}
