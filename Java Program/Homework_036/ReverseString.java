import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String input = "";

        System.out.println("Enter a string:");
        input = myScanner.nextLine();

        System.out.println(reverseString(input));

        myScanner.close();
    }

    public static String reverseString(String string) {
        String newString = ""; // Initialize an empty string to store the reversed result

        for (int i = string.length() - 1; i >= 0; i--) {
            newString += string.charAt(i); // Append each character to the newString
        }

        return newString;
    }
}
