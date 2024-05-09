import java.util.Scanner;

public class ChangeHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String output;

        // Check if the length of the string is even or odd
        if (input.length() % 2 == 0) {
            // If even, split the string in half and swap
            int middle = input.length() / 2;
            output = input.substring(middle) + input.substring(0, middle);
        } else {
            // If odd, leave the middle character in place
            int middle = input.length() / 2;
            output = input.substring(middle + 1) + input.charAt(middle) + input.substring(0, middle);
        }

        System.out.println("Output: " + output);

        scanner.close();
    }
}
