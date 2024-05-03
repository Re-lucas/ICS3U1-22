/*
    CharToString.java: Declare a character variable (char ch). Read a 
    character into the variable ch and then store it in a String variable using the 
    valueOf method. Print out both the char and string value at the end to test 
    your program.
    (Note that the valueOf method is static... this means that the method can be 
    called without an instance of the class. Therefore you can say 
    String.valueOf, this is similar to how you’ve used the random method in the 
    math class.
*/

import java.util.Scanner;

public class CharToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");

        //By inseting the next chat at index of 0 to indicate the character user wants
        char ch = scanner.next().charAt(0);
    
        String stringValue = String.valueOf(ch);
        
        System.out.println("Character value: " + ch);
        System.out.println("String value: " + stringValue);
        
        scanner.close();
    }
}
