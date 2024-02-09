/*
	File Name: HW2_Output3.java
   Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 8, 2024
	Description: Write the program to produce the following output.
*/

public class HW2_Output3{
   public static void main(String[] args){
      System.out.println("Num" + "^^^" + "Square");
      System.out.println("***" + "^^^" + "******");
   
   
   //In here, because I learned C++ before.So I found it was highly same with C++;
   //First I enter a i as ariable, and set it as 1
   //then make it loop from 1 to 5, which is <= 5
   //and make it self adding 1 times by each loop which is i++
      for (int i = 1; i <= 5; i++) {
         int The_square_of_i = i * i;
         System.out.println(i + "     " + The_square_of_i);
      }
   
   System.out.println(">");
   
   //Used for loop to looping two number
   for (int i = 1; i <= 4; i++) {
         int The_Result = i * i;
         System.out.println(i + "*" + i + "=" + The_Result);
      }
   }
}