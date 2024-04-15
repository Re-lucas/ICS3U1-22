import java.util.Scanner;

public class TableOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for two numbers x and y
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        
        // Output a table of numbers with x rows
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // Move to the next line
        }
        
        scanner.close();
    }
}
