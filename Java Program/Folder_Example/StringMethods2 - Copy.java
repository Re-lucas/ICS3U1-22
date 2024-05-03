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
      System.out.println(t1.indexOf('z'));   // returns -1
   
      // Application of the "split" method  
      String line = "Today is a beautiful day!";
      String[] words;
      
      words = line.split(" ");
      
      for (int i = 0; i < words.length; i++) {
         System.out.println(words[i]);
      }
      
      // "replace" a character at a specific index
      // Replace character in t1 at index 1 to 'a', resulting
      // t1 becomes "Hallo"
      
      // common mistake:
      //  t1.charAt(1) = 'a';
      // this does not work because charAt(1) returns a value,
      // it is not a variable, so you can not assign a value to it
      
      // proper way:
      t1 = t1.substring(0,1) + 'a' + t1.substring(2);
   }
}