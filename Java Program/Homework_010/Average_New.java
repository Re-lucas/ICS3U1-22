/*
	File Name: Average_New.java 
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:Write a program that prompts the user for five grades and 
    then displays the average of the grades. The grades are integers and they 
    must be stored in variables of type int. Real division should be performed 
    when calculating the average.
*/
import java.util.Scanner;

public class Average_New {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user for five grades
        System.out.println("Enter five grades (integers):");
        int grade1 = sc.nextInt();
        int grade2 = sc.nextInt();
        int grade3 = sc.nextInt();
        int grade4 = sc.nextInt();
        int grade5 = sc.nextInt();

        // Calculate the average
        int sum = grade1 + grade2 + grade3 + grade4 + grade5;
        double average = (double) sum / 5;

        // Display the average
        System.out.println("Average grade: " + average);

        // Close the scanner
        sc.close();
    }
}
