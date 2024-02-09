/*
	File Name: HW2_Output4.java
   Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 8, 2024
	Description: For fun (not because it’s a good habit). Try to create the 
   same output as in question 3 by using as few println or print statements as 
   possible. You may even be able to do it all in one statement
*/

public class HW2_Output4{
public static void main(String[] args){
      System.out.print("Num" + "^^^" + "Square" + "\n");//a few of print
      System.out.println("***" + "^^^" + "******"); //a few of println
   
   
   //In here, because I learned C++ before.So I found it was highly same with C++;
   //First I enter a i as ariable, and set it as 1
   //then make it loop from 1 to 5, which is <= 5
   //and make it self adding 1 times by each loop which is i++
      for (int i = 1; i <= 5; i++) {
         int The_square_of_i = i * i;
         System.out.println(i + "     " + The_square_of_i);
      }
   
   System.out.print(">" + "\n" );// a few of print
   
   //Used for loop to looping two number
   for (int i = 1; i <= 4; i++) {
         int The_Result = i * i;
         System.out.println(i + "*" + i + "=" + The_Result);
      }
   }
}