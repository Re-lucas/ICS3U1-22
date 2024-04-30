/*
   File Name: UsingMathClasses.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: April 20, 2020
	Description: This program demonstrates the use of the Math class 
*/

// this import statement is optional because the java.lang package is always
// imported by default
import java.lang.Math;

public class UsingMathClass {
	public static void main(String[] args) {
		// calling abs method in Math class
		int result = Math.abs(-100);
		System.out.println(result);
		System.out.println(Math.abs(4.5));
		
		// generate a random integer between 1 and 6 inclusively
		System.out.println((int)(Math.random() * 6) + 1);
	}
}