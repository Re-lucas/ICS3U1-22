import java.util.Scanner;

public class Biggest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double number1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double number2 = scanner.nextDouble();

        System.out.println("Enter the third number:");
        double number3 = scanner.nextDouble();

        // Find the largest number without using an if statement
        //By consedered the after compare of Math.max() inside as one number; 
        double biggestNumber = Math.max(Math.max(number1, number2), number3);

        System.out.println("The biggest number is: " + biggestNumber);

        scanner.close();
    }
}
