import java.util.Scanner;

public class AbsValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        double number = scanner.nextDouble();

        //which return the abs value of |number|
        double absoluteValue = Math.abs(number);

        System.out.println("The absolute value of " + number + " is: " + absoluteValue);

        scanner.close();
    }
}
