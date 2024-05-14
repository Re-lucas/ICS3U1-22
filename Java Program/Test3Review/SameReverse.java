public class SameReverse {
    public static void main(String[] args) {
        // Example usage: Check if "hello" and its reverse are the same
        boolean result = sameReverse("hello");
        System.out.println("Is 'hello' and its reverse the same? " + result);
    }

    public static boolean sameReverse(String s) {
        // Use the reverseString method to get the reversed value of s
        String reversed = reverseString(s);

        // Compare s and its reversed value (ignoring capitalization)
        return s.equalsIgnoreCase(reversed);
    }

    public static String reverseString(String string) {
        // Implementation of the reverse method (as shown in previous responses)
        StringBuilder reversed = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed.append(string.charAt(i));
        }
        return reversed.toString();
    }
}
