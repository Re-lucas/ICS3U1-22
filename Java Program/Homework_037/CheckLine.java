import java.util.Scanner;

public class CheckLine {

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
        double length1 = Line.length(x1_1, y1_1, x2_1, y2_1);
        double length2 = Line.length(x1_2, y1_2, x2_2, y2_2);

        // Creating an instance of Line to call the non-static method
        Line line = new Line();

        // Calculating the slopes of both lines
        double slope1 = 0;
        double slope2 = 0;
        try {
            slope1 = line.slope(x1_1, y1_1, x2_1, y2_1);
            slope2 = line.slope(x1_2, y1_2, x2_2, y2_2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        // Checking if the lengths are the same
        if (length1 == length2) {
            System.out.println("The two lines have the same length.");
        } else {
            System.out.println("The two lines do not have the same length.");
        }

        // Checking if the lines are parallel
        if (slope1 == slope2) {
            System.out.println("The two lines are parallel.");
        } else if (slope1 * slope2 == -1) {
            System.out.println("The two lines are perpendicular.");
        } else {
            System.out.println("The two lines are neither parallel nor perpendicular.");
        }

        scanner.close();
    }
}
