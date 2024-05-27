public class Line {

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
}
