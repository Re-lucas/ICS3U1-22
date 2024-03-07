/*
	File Name: BoilingWater.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 7,2024
	Description: 
*/
import java.util.Scanner;

public class BoilingWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the temperature at which water begins to boil
        System.out.print("Enter the temperature (°C) at which water begins to boil: ");
        double boilingTemperature = scanner.nextDouble();

        // Calculate atmospheric pressure using the given formula
        double atmosphericPressure = 5 * boilingTemperature - 400;

        // Determine the sea level condition
        String seaLevelCondition;
        if (atmosphericPressure < 100) {
            seaLevelCondition = "below sea level";
        } else if (atmosphericPressure > 100) {
            seaLevelCondition = "above sea level";
        } else {
            seaLevelCondition = "at sea level";
        }

        // Output results
        System.out.println("Atmospheric pressure: " + atmosphericPressure + " kPa");
        System.out.println("You are " + seaLevelCondition + ".");

        scanner.close();
    }
}
