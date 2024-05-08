/*
Getting user input: First, we get a numeric string from the user.
Iterate over every two digits: We use a for loop to iterate over the input numeric string. Each loop processes two characters and converts them to numbers.
Getting the first digit: We use input.charAt(i) - '0' to get the character at the current index i and convert it to an integer. Here '0' is the ASCII value of the character '0', so this operation actually converts the characters '0' through '9' into integers from 0 to 9.
Determining if there is a next digit: We use if (i + 1 < input.length()) to check if there is a next character. If it exists, we get the next character and convert it to a number.
Combining two digits: If there is a next digit, we multiply the first digit by 10 and add the second digit to get a two-digit number. If there is only one digit, we simply treat it as a single digit.
Add to sum: this two-digit number is added to the sum, a variable that stores the sum of all the two-digit numbers.
Repeat until the end: the loop continues until all characters are processed.
*/

import java.util.Scanner;

public class AddPairs{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        //Ask user for a list of number
        System.out.println("Enter a String of number: ");

        //String to store
        String input = myScanner.next();

        //initilize the sum
        int sum = 0;

        //Because in this question we only needs every decimal friction (10)

        //Initializing the loop: The for loop starts at index 0, the first character of the string, 
        //and increases by 2 each time it loops, which means we skip one character at a time to the next pair of numbers.
        for (int i = 0; i < input.length(); i += 2) {

            //Get the first digit: use input.charAt(i) - '0' to get the character at the current index i and convert it to an integer. 
            int firstDigit = input.charAt(i) - '0' ;//Here '0' is the ASCII value of the character '0', so this operation actually converts the characters '0' through '9' into integers from 0 to 9.

            int secondDigit = 0;
            int twoDigitNumber = 0;

            // if there is a next digit, get the second digit        
            if(i + 1 < input.length() ){
                secondDigit = input.charAt(i + 1) - '0';
                twoDigitNumber = firstDigit * 10 + secondDigit; // Combine two digits
            }else{
                twoDigitNumber = firstDigit; // If there is only one digit, treat it as a single digit.
            }

            sum += twoDigitNumber;

        }

        System.out.println("The sum of two String of number are: " + sum);

        myScanner.close();

    }
}
    