import java.util.Scanner;

public class BalanceScale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the weight of the jewellery: ");
        int weight = scanner.nextInt();
        scanner.close();

        int weight20g = 0, weight5g = 0, weight1g = 0;

        // Using the largest weight first for efficiency
        weight20g = weight / 20;
        weight %= 20;

        weight5g = weight / 5;
        weight %= 5;

        weight1g = weight; // The remainder will be the number of 1g weights needed

        System.out.println("Weights needed to balance the jewellery:");
        if (weight20g > 0) {
            System.out.println("20g weights: " + weight20g);
        }
        if (weight5g > 0) {
            System.out.println("5g weights: " + weight5g);
        }
        if (weight1g > 0) {
            System.out.println("1g weights: " + weight1g);
        }
    }
}
