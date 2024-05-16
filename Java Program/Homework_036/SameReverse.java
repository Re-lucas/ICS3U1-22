public class SameReverse {
    public static boolean sameReverse(String s) {
        if (s == null) {
            return true;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }

    public static void main(String[] args) {
        String testString = "piano";
        System.out.println(sameReverse(testString)); // Output: true
    }
}
