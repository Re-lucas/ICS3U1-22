/*
	File Name: 
	Name: 
   	Class: ICS3U1-01
	Date: 
	Description: 
*/

/*
Selection – if…else if…else structure
1. Simplify the following sequence using if–else if structure so that the 
effect is the same but fewer comparisons are required.
if (temperature > maxTemp) {
System.out.println(“Porridge too hot”);
}
if (temperature < minTemp) {
System.out.println(“Porridge too cold”);
}
if (temperature >= minTemp && temperature <= maxTemp) 
{
System.out.println(“Porridge just right!”);
*/

import java.util.Scanner;

public class homework_012_01 {
    public static void main (String [] args){
        Scanner myScanner = new Scanner(System.in);

        int temperature;
        int maxTemp = 30;
        int minTemp = 1;

        System.out.println("Please enter day's temperature: ");
        temperature = myScanner.nextInt();

        if (temperature > maxTemp) {
            System.out.println("Porridge too hot");
        } else if (temperature < minTemp) {
            System.out.println("Porridge too cold");
        } else {
            System.out.println("Porridge just right!");
        }        

        myScanner.close();
    }
}