/*
	File Name: Quadrant.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description: A common problem in mathematics is to determine which 
    quadrant a given point lies in. There are four quadrants, numbered from 1 to 4, 
    as shown in the diagram below: 
    For example, the point A, which is at coordinates (12, 5) lies in quadrant 1 
    since both its x and y values are positive, and point B lies in quadrant 2 since 
    its x value is negative and its y value is positive. Write a program that takes
    a point (given by the x and y coordinates) and determines the quadrant it is in. 
    You can assume that neither of the two coordinates will be 0.
*/

import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*For determine the quadrant we can use variable x and y, then determine are they zero or not */

        // Input x and y coordinates
        System.out.print("Enter the x coordinate: ");
        int x = scanner.nextInt();

        System.out.print("Enter the y coordinate: ");
        int y = scanner.nextInt();

        // Determine the quadrant
        int quadrant;
        if (x > 0 && y > 0) {
            quadrant = 1;
        } else if (x < 0 && y > 0) {
            quadrant = 2;
        } else if (x < 0 && y < 0) {
            quadrant = 3;
        } else {
            quadrant = 4;
        }

        // Output the result
        System.out.println("The point (" + x + ", " + y + ") lies in quadrant " + quadrant);

        // Close the scanner
        scanner.close();
    }
}
