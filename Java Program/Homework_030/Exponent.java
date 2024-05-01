import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base (b):");
        double base = scanner.nextDouble();

        System.out.println("Enter the exponent (e):");
        double exponent = scanner.nextDouble();

        double result = Math.pow(base, exponent);

        System.out.println("The result of " + base + " raised to the power of " + exponent + " is: " + result);

        scanner.close();
    }
}
