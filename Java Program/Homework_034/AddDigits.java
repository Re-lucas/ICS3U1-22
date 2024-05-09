import java.util.Scanner;

public class AddDigits{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        String input = myScanner.nextLine();
        int sum = 0;

        //by using a chatAt() method to loop over each number
        for (int i = 0; i < input.length(); i++){
            char digitChar = input.charAt(i); //get the current number
            int digit = digitChar - '0' ;//the method can convert char into digit

            //there is another method by no using getNumbericValue() 
            //int digit = digitChar - '0' ;

            //Numbers can be obtained by converting a character to its corresponding ASCII value and subtracting the ASCII value of the character '0'. 
            //This is because the numeric characters '0' through '9' are consecutive in the ASCII table, so the ASCII value for '0' is 48, and the ASCII value for '1' is 49.
            sum += digit;
        }

        System.out.println("The number of the sum is: " + sum);

        myScanner.close();
    }
}