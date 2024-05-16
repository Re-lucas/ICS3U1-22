public class CapitalOnly {
    public static String capitalOnly(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "EVAN Z. Must Wear Glasses!";
        String output = capitalOnly(input);
        System.out.println(output); // Output: EVANZMWG
    }
}
