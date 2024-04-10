import java.util.Scanner;

public class SquareCube {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the upper limit
        System.out.print("Upper Limit: ");
        int N = scanner.nextInt();

        int sumOfSquares = 0;
        int sumOfCubes = 0;

        // Compute the sum of squares and sum of cubes
        for (int i = 1; i <= N; i++) {
            sumOfSquares += i * i;
            sumOfCubes += i * i * i;
        }

        // Output the results
        System.out.println("The sum of Squares is " + sumOfSquares);
        System.out.println("The sum of Cubes is " + sumOfCubes);

        scanner.close();
    }
}
