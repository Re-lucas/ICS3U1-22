public class PerfectSquare {
    public static void main(String[] args) {
        // Example usage: Check if 25 is a perfect square
        boolean result = perfectSquare(25);
        System.out.println("Is 25 a perfect square? " + result);
    }

    public static boolean perfectSquare(int n) {
        if (n < 0) {
            return false; // Negative numbers are not perfect squares
        }

        // Calculate the square root of n
        double sqrt = Math.sqrt(n);

        // Check if the square root is an integer
        return sqrt == (int) sqrt;
    }
}
