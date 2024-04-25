import java.util.Scanner;

public class Array2DOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        // Input 9 integers into the 3x3 array
        System.out.println("Enter 9 integers for the 3x3 array:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Check rows and columns for all odd or all even integers
        boolean[] rowIsOdd = new boolean[3];
        boolean[] colIsOdd = new boolean[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] % 2 == 0) {
                    rowIsOdd[i] = false;
                    colIsOdd[j] = false;
                } else {
                    rowIsOdd[i] = true;
                    colIsOdd[j] = true;
                }
            }
        }

        // Output the results
        for (int i = 0; i < 3; i++) {
            if (rowIsOdd[i]) {
                System.out.println("Row " + i + " contains all odd integers.");
            }
            if (colIsOdd[i]) {
                System.out.println("Column " + i + " contains all odd integers.");
            }
        }
    }
}
