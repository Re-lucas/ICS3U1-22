import java.util.Scanner;

public class CheckLine {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Getting the coordinates for the first line
        System.out.println("Please enter the two coordinates of line 1:");
        int x1_1 = getCoordinate(myScanner, "Vertex 1 x-value");
        int y1_1 = getCoordinate(myScanner, "Vertex 1 y-value");
        int x2_1 = getCoordinate(myScanner, "Vertex 2 x-value");
        int y2_1 = getCoordinate(myScanner, "Vertex 2 y-value");

        // Getting the coordinates for the second line
        System.out.println("Please enter the two coordinates of line 2:");
        int x1_2 = getCoordinate(myScanner, "Vertex 1 x-value");
        int y1_2 = getCoordinate(myScanner, "Vertex 1 y-value");
        int x2_2 = getCoordinate(myScanner, "Vertex 2 x-value");
        int y2_2 = getCoordinate(myScanner, "Vertex 2 y-value");

        myScanner.close();

        // Calculating the lengths of both lines
        double length1 = calculateLength(x1_1, y1_1, x2_1, y2_1);
        double length2 = calculateLength(x1_2, y1_2, x2_2, y2_2);

        // Checking if the lengths are the same
        if (length1 == length2) {
            System.out.println("The two lines have the same length.");
        } else {
            System.out.println("The two lines do not have the same length.");
        }

        // Checking if the lines are parallel
        if (checkParallelOrPerpendicular(x1_1, y1_1, x2_1, y2_1, x1_2, y1_2, x2_2, y2_2)) {
            System.out.println("The two lines are parallel.");
        } else if (slope(x1_1, y1_1, x2_1, y2_1) * slope(x1_2, y1_2, x2_2, y2_2) == -1) {
            System.out.println("The two lines are perpendicular.");
        } else {
            System.out.println("The two lines are neither parallel nor perpendicular.");
        }
    }

    // Method to get a coordinate from the user
    public static int getCoordinate(Scanner scanner, String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }

    // Method to calculate the length of a line
    public static double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Method to check if the lines are parallel or perpendicular
    private static boolean checkParallelOrPerpendicular(int x1_1, int y1_1, int x2_1, int y2_1,
                                                        int x1_2, int y1_2, int x2_2, int y2_2) {
        return slope(x1_1, y1_1, x2_1, y2_1) == slope(x1_2, y1_2, x2_2, y2_2);
    }

    // Method to calculate the slope of a line
    public static double slope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            throw new ArithmeticException("Slope is undefined (vertical line).");
        }
        return (double) (y2 - y1) / (x2 - x1);
    }
}
