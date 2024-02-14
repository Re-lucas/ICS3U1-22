/*
	File Name: 
	Name: 
   Class: ICS3U1-01
	Date: 
	Description: 
*/

import java.util.Scanner;

public class Snow_Input_Example {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        int cm_snow;
        Double hour_Homework;

        System.out.print("How many centimeters of snow today? Please enter the number here: ");
        cm_snow = myObj.nextInt();

        System.out.println("The snow depth at Taogay is " + cm_snow + " centimeters.");

        System.out.print("How many hours have you spent on today's homework? ");
        hour_Homework = myObj.nextDouble();

        System.out.println("You have spent " + hour_Homework + " hours on today's homework.");

        myObj.close();
    }
}
