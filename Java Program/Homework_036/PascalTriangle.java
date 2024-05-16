public class PascalTriangle {
    public static void pascalTriangle(int n) {
        for (int row = 0; row < n; row++) {
            int num = 1;
            for (int spaces = 0; spaces < n - row; spaces++) {
                System.out.print(" "); // Print leading spaces
            }
            for (int col = 0; col <= row; col++) {
                System.out.print(num + " ");
                num = num * (row - col) / (col + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7; // Change this value to generate Pascal's Triangle for a different 'n'
        pascalTriangle(n);
    }
}
