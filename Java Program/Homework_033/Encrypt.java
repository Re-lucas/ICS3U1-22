import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = scanner.nextLine();

        if (input.length() < 3) {
            System.out.println("The encryption is: " + input);
        } else {
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);
            String middleSubstring = input.substring(1, input.length() - 1);

            StringBuilder encrypted = new StringBuilder();
            encrypted.append(lastChar);

            for (int i = 0; i < middleSubstring.length(); i++) {
                char c = middleSubstring.charAt(i);
                if (c != ' ') {
                    encrypted.append((char) (c + 2));
                } else {
                    encrypted.append(' ');
                }
            }

            encrypted.append(firstChar);
            System.out.println("The encryption is: " + encrypted.toString());
        }
    }
}
