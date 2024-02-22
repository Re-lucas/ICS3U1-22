/* 
    File Name: Energy.java
    Name: Lucas Wu
    Date: Feb 21, 2024
    Course: ICS3U1
    Description:Einstein’s famous formula, e=mc2, gives the amount of energy 
    released by the complete conversion of matter of mass m into energy e. If m
    represents the mass in kilograms and c represents the speed of light in 
    meters per second (3.0 * 108 m/s), then the result is in the energy units 
    Joules. It takes 360000 Joules to light a 100-watt light bulb for an hour. 
    Create a program that prompts that user for a mass in kilograms and then 
    displays the energy and the number of light bulbs that could be powered.

*/
import java.util.Scanner;

public class Energy {
    public static void main(String[] args) {
        // Define the speed of light
        double c = 3.0 * Math.pow(10, 8);  // in m/s

        // Define the energy required to light a 100-watt light bulb for an hour
        double energyPerBulb = 360000;  // in Joules

        // Create a Scanner object for user input
        Scanner myScanner = new Scanner(System.in);

        // Prompt the user for a mass in kilograms
        System.out.print("Enter a mass in kilograms: ");
        double m = myScanner.nextDouble();

        // Calculate the energy
        double e = m * Math.pow(c, 2);

        // Calculate the number of light bulbs that could be powered
        double numBulbs = e / energyPerBulb;

        // Display the results
        System.out.println("Energy: " + e + " Joules");
        System.out.println("Number of 100-watt light bulbs that could be powered for an hour: " + numBulbs);

        myScanner.close();
    }
}
