// TimesTable.java

public class TimesTable {
    public static void main(String[] args) {
        // Create a 2D array to store the multiplication table
        int[][] multiplicationTable = new int[12][12];

        // Fill in the multiplication table
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                multiplicationTable[row][col] = (row + 1) * (col + 1);
            }
        }

        // Print the multiplication table
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                System.out.printf("%4d", multiplicationTable[row][col]);
            }
            System.out.println();
        }
    }
}
