import java.util.Scanner;

public class CheckLine {
    
    // Static method to calculate the length of a line segment
    public static double length(int x1, int y1, int x2, int y2) {
        // Using the distance formula to calculate the length
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Non-static method to calculate the slope of a line segment
    public double slope(int x1, int y1, int x2, int y2) {
        // Using the slope formula to calculate the slope
        if (x2 - x1 == 0) {
            throw new ArithmeticException("Slope is undefined (vertical line)");
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    // Main method for user input and checking line properties
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the coordinates for the first line
        System.out.println("Please enter the two coordinates of line 1:");
        System.out.print("Vertex 1 x-value: ");
        int x1_1 = scanner.nextInt();
        System.out.print("Vertex 1 y-value: ");
        int y1_1 = scanner.nextInt();
        System.out.print("Vertex 2 x-value: ");
        int x2_1 = scanner.nextInt();
        System.out.print("Vertex 2 y-value: ");
        int y2_1 = scanner.nextInt();

        // Getting the coordinates for the second line
        System.out.println("Please enter the two coordinates of line 2:");
        System.out.print("Vertex 1 x-value: ");
        int x1_2 = scanner.nextInt();
        System.out.print("Vertex 1 y-value: ");
        int y1_2 = scanner.nextInt();
        System.out.print("Vertex 2 x-value: ");
        int x2_2 = scanner.nextInt();
        System.out.print("Vertex 2 y-value: ");
        int y2_2 = scanner.nextInt();

        // Calculating the lengths of both lines
        double length1 = CheckLine.length(x1_1, y1_1, x2_1, y2_1);
        double length2 = CheckLine.length(x1_2, y1_2, x2_2, y2_2);

        // Creating an instance of Line to call the non-static method
        CheckLine line = new CheckLine();

        // Calculating the slopes of both lines
        double slope1 = 0;
        double slope2 = 0;
        boolean slope1Defined = true;
        boolean slope2Defined = true;

        try {
            slope1 = line.slope(x1_1, y1_1, x2_1, y2_1);
        } catch (ArithmeticException e) {
            slope1Defined = false;
            System.out.println("Slope of line 1 is undefined.");
        }

        try {
            slope2 = line.slope(x1_2, y1_2, x2_2, y2_2);
        } catch (ArithmeticException e) {
            slope2Defined = false;
            System.out.println("Slope of line 2 is undefined.");
        }

        // Checking if the lengths are the same
        if (Math.abs(length1 - length2) < 1e-9) {
            System.out.println("The two lines have the same length.");
        } else {
            System.out.println("The two lines do not have the same length.");
        }

        // Checking if the lines are parallel or perpendicular
        if (slope1Defined && slope2Defined) {
            if (Math.abs(slope1 - slope2) < 1e-9) {
                System.out.println("The two lines are parallel.");
            } else if (Math.abs(slope1 * slope2 + 1) < 1e-9) {
                System.out.println("The two lines are perpendicular.");
            } else {
                System.out.println("The two lines are neither parallel nor perpendicular.");
            }
        }

        scanner.close();
    }
}
