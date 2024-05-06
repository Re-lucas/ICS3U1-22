import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = scanner.nextLine();

        // Split the input into words using spaces as delimiters
        String[] words = input.split(" ");
        StringBuilder encrypted = new StringBuilder();

        for (String word : words) {
            if (word.length() < 3) {
                // Handle words less than 3 characters (leave them unchanged)
                encrypted.append(word).append(" ");
            } else {
                // Swap first and last characters
                char[] chars = word.toCharArray();
                char temp = chars[0];
                chars[0] = chars[word.length() - 1];
                chars[word.length() - 1] = temp;

                // Shift middle characters by 2 in ASCII table
                for (int i = 1; i < word.length() - 1; i++) {
                    char c = chars[i];
                    if (!Character.isWhitespace(c)) {
                        chars[i] = (char) (c + 2);
                    }
                }

                encrypted.append(new String(chars)).append(" ");
            }
        }

        System.out.println("The encryption is: " + encrypted.toString().trim());

        scanner.close();
    }
}
