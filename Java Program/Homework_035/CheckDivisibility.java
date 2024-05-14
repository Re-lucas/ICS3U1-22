public class CheckDivisibility {
    public static void main(String[] args) {
        // Example usage: Check if 15 is evenly divisible by 3
        boolean result = evenlyDivisible(15, 3);
        System.out.println("Is 15 evenly divisible by 3? " + result);
    }

    public static boolean evenlyDivisible(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            return false;
        } else {
            return num1 % num2 == 0 || num2 % num1 == 0;
        }
    }
}
