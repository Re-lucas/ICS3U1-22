import java.util.Scanner;

public class LineSlope {
    // Method to calculate the length of a line segment
    public static double length(int x1, int y1, int x2, int y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    // Method to calculate the slope of a line segment
    public static double slope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            System.out.println("Warning: Vertical line. Slope is undefined.");
            return Double.NaN;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Line 1
        System.out.println("Please enter the two coordinates of line 1:");
        System.out.print("Vertex 1 x-value: ");
        int x1 = scanner.nextInt();
        System.out.print("Vertex 1 y-value: ");
        int y1 = scanner.nextInt();
        System.out.print("Vertex 2 x-value: ");
        int x2 = scanner.nextInt();
        System.out.print("Vertex 2 y-value: ");
        int y2 = scanner.nextInt();

        // Input for Line 2
        System.out.println("\nPlease enter the two coordinates of line 2:");
        System.out.print("Vertex 1 x-value: ");
        int x3 = scanner.nextInt();
        System.out.print("Vertex 1 y-value: ");
        int y3 = scanner.nextInt();
        System.out.print("Vertex 2 x-value: ");
        int x4 = scanner.nextInt();
        System.out.print("Vertex 2 y-value: ");
        int y4 = scanner.nextInt();

        // Calculate lengths
        double length1 = Line.length(x1, y1, x2, y2);
        double length2 = Line.length(x3, y3, x4, y4);

        // Check if lengths are equal
        if (length1 == length2) {
            System.out.println("\nThe two lines have the same length.");
        } else {
            System.out.println("\nThe two lines do not have the same length.");
        }

        // Check if lines are parallel or perpendicular
        double slope1 = Line.slope(x1, y1, x2, y2);
        double slope2 = Line.slope(x3, y3, x4, y4);

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
}
