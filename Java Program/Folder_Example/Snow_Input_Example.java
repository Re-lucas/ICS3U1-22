/*
	File Name: Snow_Input_Example.java
	Name: Lucas Wu
    Class: ICS3U1-01
	Date: Feb 14, 2024 
	Description: 
*/

import java.util.Scanner;

public class Snow_Input_Example {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        int cm_snow;
        Double hour_Homework;
        String school_location;

        //Interger variable for snow example
        System.out.print("How many centimeters of snow today? Please enter the number here: ");
        cm_snow = myObj.nextInt();
        myObj.nextLine(); // add this line

        System.out.println("The snow depth at Taogay is " + cm_snow + " centimeters.");

        //Double variable for homwork example
        System.out.print("How many hours have you spent on today's homework? ");
        hour_Homework = myObj.nextDouble();
        myObj.nextLine(); // add this line

        System.out.println("You have spent " + hour_Homework + " hours on today's homework.");

        //String variable for location example
        System.out.print("Please enter your school location: ");
        school_location = myObj.nextLine();
        myObj.nextLine(); // add this line

        System.out.println("here is your school location: " + school_location);

        myObj.close();
    }
}
