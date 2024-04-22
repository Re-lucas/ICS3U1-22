// StarTable.java

import java.util.Scanner;

public class StarTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the dimensions of the table
        System.out.print("Enter the number of rows for the table: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for the table: ");
        int cols = scanner.nextInt();

        // Create a 2D array of characters with specified dimensions
        char[][] starTable = new char[rows][cols];

        // Initialize each element to be '*'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                starTable[i][j] = '*';
            }
        }

        // Print out the content of the array as a table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(starTable[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
