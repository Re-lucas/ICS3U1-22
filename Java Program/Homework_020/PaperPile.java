import java.util.Scanner;

public class PaperPile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the number of repetitions (x): ");
        int x = scanner.nextInt();

        // Initial area and thickness
        double initialArea = 1.0; // m^2
        double initialThickness = 0.090 / 1000.0; // Convert mm to meters

        // Calculate the thickness of the pile after x repetitions
        double pileThickness = initialThickness * Math.pow(2, x);

        // Calculate the area of each piece after x repetitions
        double pieceArea = initialArea / Math.pow(2, x);

        // Print the results
        System.out.printf("Pile thickness after %d repetitions: %.6f meters%n", x, pileThickness);
        System.out.printf("Area of each piece after %d repetitions: %.6f m^2%n", x, pieceArea);

        scanner.close();
    }
}
