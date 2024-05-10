import java.util.Scanner;

public class NumberPresent {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a list of Numbers:");
        String input = myScanner.next();

        int[] arrays = new int[10];

        // Converts the input number to the corresponding position in the array plus one
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (Character.isDigit(digit)) {
                arrays[digit - '0']++;
            }
        }

        boolean allPresent = true;

        // Check that the numbers 0 through 9 all appear in the input
        System.out.println("Here are the not present numbers:");
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                System.out.println(i);
                allPresent = false;
            }
        }

        if (allPresent) {
            System.out.println("All numbers are present.");
        }

        myScanner.close();
    }
}
