import java.util.Scanner;

public class Bigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double number1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double number2 = scanner.nextDouble();

        //By using the Math.max(num1 , num2) to compare the two of numbers;
        double biggerNumber = Math.max(number1, number2);

        System.out.println("The bigger number is: " + biggerNumber);

        scanner.close();
    }
}
