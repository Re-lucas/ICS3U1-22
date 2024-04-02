public class Unicode {
    public static void main(String[] args) {
        int start = 1;
        int end = 212;

        do {
            char unicodeChar = (char) start;
            System.out.println(start + " " + unicodeChar);
            start++;
        } while (start <= end);
    }
}
