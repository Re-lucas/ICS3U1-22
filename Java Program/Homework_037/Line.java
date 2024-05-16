public class Line {
    public static double length(int x1, int y1, int x2, int y2) {
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double slope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            System.out.println("Warning: Vertical line. Slope is undefined.");
            return Double.NaN;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    public static void main(String[] args) {
        // Example usage:
        int x1 = 2, y1 = 3;
        int x2 = 5, y2 = 7;

        System.out.println("Length of the line segment: " + length(x1, y1, x2, y2));

        Line line = new Line();
        System.out.println("Slope of the line segment: " + line.slope(x1, y1, x2, y2));
    }
}
