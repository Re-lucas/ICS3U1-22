import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = scanner.nextLine();
        
        if (input.length() < 3) {
            // Handle strings less than 3 characters (leave them unchanged)
            System.out.println("The encryption is: " + input);
        } else {
            char[] chars = input.toCharArray();
            // Swap first and last characters
            char temp = chars[0];
            chars[0] = chars[input.length() - 1];
            chars[input.length() - 1] = temp;

            // Shift middle characters by 2 in ASCII table
            for (int i = 1; i < input.length() - 1; i++) {
                char c = chars[i];
                if (!Character.isWhitespace(c)) {
                    chars[i] = (char) (c + 2);
                }
            }

            System.out.println("The encryption is: " + new String(chars));
        }

        scanner.close();
    }
}
