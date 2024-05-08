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
        for (int i = 0; i < input.length(); i += 2) {
            int firstDigit = input.charAt(i) - '0' ;


            int secondDigit = 0;

            if(i + 1 < input.length() ){
                secondDigit = input.charAt(i + 1) - '0';
            }

            int twoDigitNumber = firstDigit * 10 + secondDigit; 
            sum += twoDigitNumber;

            
        }

        System.out.println("The sum of two String of number are: " + sum);

        myScanner.close();

    }
}
    