import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the number of rows and columns
        System.out.print("Enter # of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter # of columns: ");
        int columns = scanner.nextInt();
        
        // Draw the rectangle with stars
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
        
        scanner.close();
    }
}
