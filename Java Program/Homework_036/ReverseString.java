import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        try (Scanner myScanner = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String input = myScanner.nextLine();
            
            System.out.println(reverseString(input));
        }
    }

    public static String reverseString(String string) {
        //because the question ask for reverse the string which just print each backward and combine it
        String newString = ""; // Initialize an empty string to store the reversed result

        for (int i = string.length() - 1; i >= 0; i--) {
            newString += string.charAt(i); // Append each character to the newString
        }

        return newString;
    }
}
