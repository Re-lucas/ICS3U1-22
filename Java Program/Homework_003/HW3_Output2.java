/*
File Name: HW3_Output2.java
  Name: Lucas Wu
Class: ICS3U1-01
Date: Feb 9, 2024
Description:Determine the output of each of the following statements. Assume tab occurs every 5 
  spaces. Please use ‘^’ to represent space, and ‘>’ to represent blank line*/

public class HW3_Output2{
   public static void main(String[] args){
   
      // a) The output result is: 
      // Silly
      System.out.println("silly");
      
      // b) The output result is:
      //The^answer^is:^^
      System.out.println ("The^answer^is:^^");
      
      // c) The output result is:
      // abc
      System.out.println("abc");
      
      // d) The output result is (five of ^ represnt a tab):
      // ^^^^^he^answer
      // is
      System.out.print("\the^answer\nis");
      
      // e) The output result is (> represent a line):
      // yes
      // >
      // name
      System.out.println("yes\n\nname");
      
      // f) The output result is:
      // \\\n2+3
      System.out.println ("\\\\\\n2+3");
      
      // g) The output result is:
      // >
      // \^^^^^hhhh
      // >
      // A
      System.out.println ("\n\\\thhhh\n\n"+"A");
      
      // h) The output result is:
      // bigNew
      // York
      // >
      // apple
      System.out.print("big");
      System.out.println("New\nYork\n");
      System.out.println("apple");
      
      // i) The output result is:
      // 34.789
      System.out.println(34.789);
      
      // j) The output result is:
      // 12
      // 4*3
      System.out.println(4*3);
      System.out.println("4*3");
      
      // k) The output result is: 
      // 5*6=30
      System.out.println("5*6=" + (5 * 6));

      // l)The output result is:
      // 333
      // 63
      System.out.println("3" + 3 + 3);
      System.out.println(3 + 3 + "3");
      
      // m) The output result is:
      // 7
      // 5+2
      // 52
      // 52
      // 7
      System.out.println(5+2); 
      System.out.println("5+2");
      System.out.println("5"+"2");
      System.out.println(""+ 5 + 2);
      System.out.println(5+2+"");
      
      // n) The output result is:
      // 78.3
      System.out.println(78.3);
      
      // o) The output result is:
      // 58524.2
      // 5*2
      System.out.println(5+"85"+24.2+"\n5*2");
      
      // p) The output result is:
      // 8+8=^88
      // 16=8*8
      System.out.println ("8+8=^"+8+8);
      System.out.println (8+8+"=8*8");
   }
}