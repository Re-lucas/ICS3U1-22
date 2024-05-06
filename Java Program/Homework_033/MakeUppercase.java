import java.util.Scanner;

public class MakeUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        String uppercaseEquivalent = toUppercase(input);
        System.out.println("Uppercase Equivalent: " + uppercaseEquivalent);

        scanner.close();
    }

    private static String toUppercase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
