public class CalculateSum {
    public static void main(String[] args) {
        // Example usage: Calculate the sum of integers from 50 to 75 (inclusive)
        int result = sumRange(50, 75);
        System.out.println("Sum of integers in the range: " + result);
    }

    public static int sumRange(int start, int end) {

        //here ask for a int type method and determine the sencond number have to be larger than teh first number
        if (end < start) {
            System.out.println("Error: Second parameter must be greater than or equal to the first.");
            return 0;
        } else {
            //if the second num larger than the first num
            // it will get the sum betweeen and include of this two number
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
