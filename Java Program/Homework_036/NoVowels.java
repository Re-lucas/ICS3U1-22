public class NoVowels {
    public static String noVowels(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!isVowel(c)) {
                if (c == 'S') {
                    result.append('$');
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String input = "DAVID wears glasses.";
        String output = noVowels(input);
        System.out.println(output); // Output: DVD wrs glsss.
    }
}
