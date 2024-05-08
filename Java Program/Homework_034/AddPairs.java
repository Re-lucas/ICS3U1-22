/*
Getting User Input: First, we need to get a number from the user. We can use the Scanner class to read the user input.

Iterate over every two digits: We need to iterate over the input and process two digits at a time. If the number of digits is odd, the last digit will be processed separately.

Calculate the sum of the two digits: For each two digits, we add them together and add the result to the sum.

Outputting the sum: finally, we output the calculated sum to the user.

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

            //Initializing the second digit: we declare a variable secondDigit and initialize it to 0. 
            //This is to handle the case where the length of the digit string is odd, so that the last digit is handled separately.
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
    