/** 
	File Name: Input_4.java
	Name: Lucas Wu
    Class: ICS3U1-01
	Date: Feb 13,2024
	Description: Write a program that asks the user to enter two words, then 
    output them on separate lines, and then output them again on the same line 
    separated by a tab.
*/

import java.util.Scanner;

public class Input_4 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("Please enter word #1: ");
        String word1 = myScanner.nextLine();

        System.out.print("Please enter word #2: ");
        String word2 = myScanner.nextLine();

        // Output on separate lines
        System.out.println(word1);
        System.out.println(word2);

        // Output on the same line separated by a tab
        System.out.println(word1 + "\t" + word2);

        myScanner.close();
    }
}

