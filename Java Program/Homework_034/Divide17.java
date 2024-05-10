import java.util.Scanner;

public class Divide17 {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the first number");
        long firstNumber = myScanner.nextLong();
        System.out.println("Enter the second number");
        long secondNumber = myScanner.nextLong();

        /*
        the method of int length = String.valueOf(secondNumber).length(); 
        whcih is same as (convert String to char):
            String secondString = secondNumber + "";
        than:
            int length = secondString.length();
         */

        int length = String.valueOf(secondNumber).length();

        /*The double newNumber = firstNumber * Math.pow(10, length) + secondNumber;
            which same as:
            firstNumber * 10^length + secondNumber; The Math.pow(10, length) method same as 10^length;

            The purpose of this is to move the firstNumber to the left 
            by length to leave enough room for the secondNumber to merge the two numbers into a new one. 
         */
        
        double newNumber = firstNumber * Math.pow(10, length) + secondNumber;
        double result = newNumber/17;
        
        System.out.printf("The result is: %.2f" , result);

        myScanner.close();
    }
}
