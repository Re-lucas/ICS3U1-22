import java.util.Scanner;

public class AddUnicodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += c; // Adds the Unicode value of the character to the sum
        }

        System.out.println("Sum of the Unicodes = " + sum);

        scanner.close();
    }
}
