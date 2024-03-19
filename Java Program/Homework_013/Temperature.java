/*
	File Name: Temperature.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description: Write a program that asks the user to enter a temperature 
    in degrees Celsius. The program prints a message based on the following:
    below -18 very cold
    -18 or below 0 cold
    0 freezing point of water
    above 0 to 10 very cool
    above 10 to 20 moderate
    above 20 to 30 warm
    above 30 to 40 hot
    above 40 to below 100 extremely hot
    100 boiling point of water
*/

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a temperature in degrees Celsius:");
        int temp = scanner.nextInt();

        if (temp < -18) {
            System.out.println(temp + " - Very cold");
        } else if (temp <= 0) {
            System.out.println(temp + " - Cold");
        } else if (temp == 0) {
            System.out.println(temp + " - Freezing point of water");
        } else if (temp <= 10) {
            System.out.println(temp + " - Very cool");
        } else if (temp <= 20) {
            System.out.println(temp + " - Moderate");
        } else if (temp <= 30) {
            System.out.println(temp + " - Warm");
        } else if (temp <= 40) {
            System.out.println(temp + " - Hot");
        } else if (temp < 100) {
            System.out.println(temp + " - Extremely hot");
        } else if (temp == 100) {
            System.out.println(temp + " - Boiling point of water");
        }

        scanner.close();
    }
}
