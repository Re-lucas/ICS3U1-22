/* 
	File Name: StringMethods2.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: May 3, 2020
	Description: This program demonstrates the usage of more methods of the 
   String class
*/

public class StringMethods2{
   public static void main (String[] args) {
      String t1 = "Hello";
      String t2 = "World";
      
      // The "concat" method is exactly the same as the "+" operation
      String t3;
      
      t3 = t1.concat(t2);
      System.out.println(t3);
      
      t3 = t1 + t2;
      System.out.println(t3);
      
      // Note that String in non-mutable.  So with the assignment below, the 
      // "content" of the String does not change, the result got saved in 
      // another location and got stored in t1.
      t1 = t1 + t2;
      
      // "indexOf" method
      System.out.println(t1.indexOf('l'));
      System.out.println(t1.indexOf('l', 3));
   
      // Application of the "split" method  
      String line = "Today is a beautiful day!";
      String[] words;
      
      words = line.split(" ");
      
      for (int i = 0; i < words.length; i++) {
         System.out.println(words[i]);
      }
            
   }
}