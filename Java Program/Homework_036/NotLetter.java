public class NotLetter {
    public static boolean notLetter(char c) {
        return !Character.isLetter(c);
    }

    public static void main(String[] args) {
        char testChar = '7'; // Example character to test
        System.out.println(notLetter(testChar)); // Output: true
    }
}
