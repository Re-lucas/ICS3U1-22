import java.util.Scanner;

public class CheckLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Line 1
        System.out.println("Please enter the two coordinates of line 1:");
        int x1 = getUserInput("Vertex 1 x-value: ", scanner);
        int y1 = getUserInput("Vertex 1 y-value: ", scanner);
        int x2 = getUserInput("Vertex 2 x-value: ", scanner);
        int y2 = getUserInput("Vertex 2 y-value: ", scanner);

        // Input for Line 2
        System.out.println("\nPlease enter the two coordinates of line 2:");
        int x3 = getUserInput("Vertex 1 x-value: ", scanner);
        int y3 = getUserInput("Vertex 1 y-value: ", scanner);
        int x4 = getUserInput("Vertex 2 x-value: ", scanner);
        int y4 = getUserInput("Vertex 2 y-value: ", scanner);

        // Calculate lengths
        double length1 = LineSlope.length(x1, y1, x2, y2);
        double length2 = LineSlope.length(x3, y3, x4, y4);

        // Check if lengths are equal
        if (length1 == length2) {
            System.out.println("\nThe two lines have the same length.");
        } else {
            System.out.println("\nThe two lines do not have the same length.");
        }

        // Check if lines are parallel or perpendicular
        double slope1 = LineSlope.slope(x1, y1, x2, y2);
        double slope2 = LineSlope.slope(x3, y3, x4, y4);

        if (Double.isNaN(slope1) || Double.isNaN(slope2)) {
            System.out.println("Cannot determine if lines are parallel or perpendicular due to undefined slope.");
        } else if (slope1 == slope2) {
            System.out.println("The two lines are parallel.");
        } else if (slope1 * slope2 == -1) {
            System.out.println("The two lines are perpendicular.");
        } else {
            System.out.println("The two lines are neither parallel nor perpendicular.");
        }

        scanner.close();
    }

    private static int getUserInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
}
