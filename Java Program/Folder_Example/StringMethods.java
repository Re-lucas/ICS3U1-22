/* 
	File Name: StringMethods.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: May 3, 2020
	Description: This program demonstrates the usage of some methods of the 
   String class
*/

public class StringMethods{
   public static void main (String[] args) {
      String s1 = "Hello";
      String s2 = "Hi";
      
      // length() returns the length of the string
      System.out.println(s1.length());
      
      // charAt returns the char at the specified index
      
      // print out each character of a string on separate lines
      for (int i = 0; i < s1.length(); i++) {
         System.out.println(s1.charAt(i));
      }
      
      // compareTo compares two string lexicographically
      System.out.println(s1.compareTo(s2)); // s1 is "this string", s2 is the "argument string"
      System.out.println(s2.compareTo(s1)); // s2 is "this string", s1 is the "argument string"  
      
      // substring returns part of the string
      System.out.println(s1.substring(1, 3));// return string from index 1 to 2 (3-1)
      System.out.println(s1.substring(3)); // return string from index 3 to the end
   }
}