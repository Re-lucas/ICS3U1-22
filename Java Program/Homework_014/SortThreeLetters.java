/*
	File Name: SortThreeLetters.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 19
	Description:  Write a program that prompts for three lower case 
    letters. If all inputs are valid (lower case letters), output the three letters in 
    alphabetical order, otherwise, output an error message.
*/
import java.util.Scanner;

public class SortThreeLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three lowercase letters:");
        String input = scanner.nextLine();

        if (input.length() != 3) {
            System.out.println("Error: Please enter exactly three letters.");
        } else {
            char letter1 = input.charAt(0);
            char letter2 = input.charAt(1);
            char letter3 = input.charAt(2);

            if (isValidLetter(letter1) && isValidLetter(letter2) && isValidLetter(letter3)) {
                // Sort the letters
                char[] sortedLetters = {letter1, letter2, letter3};
                java.util.Arrays.sort(sortedLetters);

                System.out.println("Sorted letters: " + sortedLetters[0] + ", " + sortedLetters[1] + ", " + sortedLetters[2]);
            } else {
                System.out.println("Error: Please enter valid lowercase letters.");
            }
        }

        scanner.close();
    }

    private static boolean isValidLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
}
