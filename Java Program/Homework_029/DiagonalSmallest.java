import java.util.Scanner;

public class DiagonalSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[4][4];

        // Input 16 integers into the square array
        System.out.println("Enter 16 integers for the square array:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Initialize variables to store the smallest values
        int smallestDiagonal1 = matrix[0][0];
        int smallestDiagonal2 = matrix[0][3];

        // Find the smallest value in the main diagonal (top-left to bottom-right)
        for (int i = 0; i < 4; i++) {
            if (matrix[i][i] < smallestDiagonal1) {
                smallestDiagonal1 = matrix[i][i];
            }
        }

        // Find the smallest value in the secondary diagonal (top-right to bottom-left)
        for (int i = 0; i < 4; i++) {
            if (matrix[i][3 - i] < smallestDiagonal2) {
                smallestDiagonal2 = matrix[i][3 - i];
            }
        }

        // Output the smallest values in both diagonals
        System.out.println("Smallest value in the main diagonal: " + smallestDiagonal1);
        System.out.println("Smallest value in the secondary diagonal: " + smallestDiagonal2);

        scanner.close();
    }
}
