import java.util.Scanner;

public class Alphabets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int vowelCount = 0;

        boolean continueInput = true;

        while (continueInput) {
            System.out.print("Enter an alphabet: ");
            String input = scanner.nextLine();

            // Check if the input is a single character
            if (input.length() == 1) {
                char ch = input.charAt(0);

                // Check if the character is an alphabet
                if (Character.isLetter(ch)) {
                    // Increment counts based on the properties of the entered alphabet
                    if (Character.isUpperCase(ch)) {
                        upperCaseCount++;
                    } else {
                        lowerCaseCount++;
                    }

                    // Check if the alphabet is a vowel
                    if (isVowel(ch)) {
                        vowelCount++;
                    }
                } else {
                    continueInput = false; // Stop input loop if non-alphabet is entered
                }
            } else {
                continueInput = false; // Stop input loop if more than one character is entered
            }
        }

        // Output the counts
        System.out.println("You have entered " + upperCaseCount + " upper case alphabets.");
        System.out.println("You have entered " + lowerCaseCount + " lower case alphabets.");
        System.out.println("You have entered " + vowelCount + " vowels.");

        // Close the scanner
        scanner.close();
    }

    // Method to check if a character is a vowel
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
