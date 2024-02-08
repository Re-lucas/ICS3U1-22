/*
	File Name: Output_Example_001.java
   Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 8, 2024
	Description: This is a program showing the difference between "println" and "print".
*/

public class Output_Example_001{
   public static void main (String[] args){
      System.out.println("Hello");
      System.out.println("World");
      
      System.out.print("Hello"); //The print without "ln" does not press enter after print out Hello
      System.out.println("World");
      
      System.out.println("34567");//Print out the inside as text
      System.out.println(34567);//Print out as number
      
      System.out.println("3 + 4");//print out as text, be like "3 + 4"
      System.out.println(3 + 4);//it will show the caculation of 3 + 4 which is 7   
      }
}