/*
   File Name: UsingClasses.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: April 20, 2020
	Description: This program demonstrates how to call a static vs. non-static methods  
 */
 
// Step 1 (for calling both types of methods): import the package 
import java.util.Scanner;
import java.lang.Math;

public class UsingClasses {
   public static void main (String[] args) {
      // Step 2 & 3 for calling non-static methods: 
      // - Declare class variable
      // - construct an instance of the class
      Scanner sc = new Scanner(System.in);
      
      int age;
      System.out.print("How old are you?  ");
      // Step 4 for calling non-static methods:
      // <variable name>.<method name>
      age = sc.nextInt();
      
      // Step 2 for calling static methods:
      // <class name>.<method name>      
      double temp = Math.abs(-4.5);

      System.out.println(age + temp);

      sc.close();
   }
}