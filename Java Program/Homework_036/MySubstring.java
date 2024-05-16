public class MySubstring {
    public static String mySubstring(String s, int start, int end) {
        if (start < 0 || end > s.length() || start > end) {
            System.out.println("Invalid indices. Returning an empty string.");
            return "";
        }
        return s.substring(start, end);
    }

    public static String mySubstring(String s, int start) {
        if (start < 0 || start > s.length()) {
            System.out.println("Invalid index. Returning an empty string.");
            return "";
        }
        return s.substring(start);
    }

    public static void main(String[] args) {
        String testString = "Hello, World!";
        int startIndex = 7;
        int endIndex = 12;

        System.out.println("Substring from index " + startIndex + " to " + endIndex + ": " +
                mySubstring(testString, startIndex, endIndex));

        int singleIndex = 9;
        System.out.println("Substring from index " + singleIndex + " onwards: " +
                mySubstring(testString, singleIndex));
    }
}
