/*
	File Name: Output_Example_001.java
   Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 8, 2024
	Description: This is a program showing  the operator precedence and the string concatenation rules in Java..
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
      /*what ever inside a quotation is called string */
      
      System.out.println("World" + "World");//Print out a combination of two string
      
      // the operator precedence and the string concatenation rules in Java.
      
      System.out.println("Hello" + 3); 
      //This is because the + operator can be used to concatenate a string and another value
      
      System.out.println("Hello" + 3 + 4); 
      //This is because the + operator is evaluated from left to right, and it concatenates the values as strings
      
      System.out.println("Hello" + (3 + 4));
       //This is because the parentheses ( ) have higher precedence than the + operator, and they force the expression inside them to be evaluated first
       
      System.out.println(3 + 4 + "Hello"); 
      //This is because the + operator is evaluated from left to right, and it performs different operations depending on the types of the operands
      
      System.out.println("Hello \n World");//The \n represent as enter
      System.out.println("Hello \t World");
      //The \t represent as tab (the space depende on your computer)
      //It will fill in the rest of the space of the tab
      
      }
}