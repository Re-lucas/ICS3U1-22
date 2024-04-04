import java.util.Scanner;

public class Chart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.print("Enter the first integer (a): ");
        int a = scanner.nextInt();

        System.out.print("Enter the second integer (b): ");
        int b = scanner.nextInt();

        // Determine the start and end values for the loop
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        // Print the chart title
        System.out.println("Chart of Squares and Cubes from " + start + " to " + end + ":");

        // Print the table headers
        System.out.printf("%-10s%-10s%-10s%n", "Number", "Square", "Cube");
        System.out.println("-".repeat(30));

        // Calculate and print squares and cubes for each number
        for (int num = start; num <= end; num++) {
            int square = num * num;
            int cube = num * num * num;
            System.out.printf("%-10d%-10d%-10d%n", num, square, cube);
        }

        scanner.close();
    }
}
