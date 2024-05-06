import java.util.Scanner;

public class HiddenPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter a character: ");
        char replacement = scanner.next().charAt(0);

        String hiddenPassword = hideCharacters(input, replacement);
        System.out.println("Hidden Password: " + hiddenPassword);

        scanner.close();
    }

    private static String hideCharacters(String input, char replacement) {
        return input.replaceAll("[^ ]", String.valueOf(replacement));
    }
}
