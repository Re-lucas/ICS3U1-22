import java.util.Scanner;

public class Divide17{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the first number");

        long firstNumber = myScanner.nextLong();

        System.out.println("Enter the second number");

        long secondNumber = myScanner.nextLong();

        int length = String.valueOf(secondNumber).length();

        double newNumber = firstNumber * Math.pow(10, length) + secondNumber;

        double result = newNumber/17;

        System.out.printf("The new number is: %.2f" , result);

        myScanner.close();
    }
}