public class CalculateSum {
    public static void main(String[] args) {
        // Example usage: Calculate the sum of integers from 50 to 75 (inclusive)
        int result = sumRange(50, 75);
        System.out.println("Sum of integers in the range: " + result);
    }

    public static int sumRange(int start, int end) {
        if (end < start) {
            System.out.println("Error: Second parameter must be greater than or equal to the first.");
            return 0;
        } else {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
