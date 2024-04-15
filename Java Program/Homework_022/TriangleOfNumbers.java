public class TriangleOfNumbers {
    public static void main(String[] args) {
        // Outer loop for each line
        for (int i = 1; i <= 5; i++) {
            // Inner loop for each number on the line
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Move to the next line after printing each row
            System.out.println();
        }
    }
}
