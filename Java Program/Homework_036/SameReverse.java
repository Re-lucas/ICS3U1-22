public class SameReverse {

    // Method to reverse a given string
    public static String reverse(String s) {
        // Using StringBuilder to reverse the string
        return new StringBuilder(s).reverse().toString();
    }

    // Method to check if the string and its reverse are the same
    public static boolean sameReverse(String s) {
        // Getting the reversed string
        String reversed = reverse(s);
        // Comparing the original string with the reversed string
        return s.equals(reversed);
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "madam";
        String test2 = "hello";
        
        System.out.println("Is \"" + test1 + "\" the same as its reverse? " + sameReverse(test1)); // true
        System.out.println("Is \"" + test2 + "\" the same as its reverse? " + sameReverse(test2)); // false
    }
}
