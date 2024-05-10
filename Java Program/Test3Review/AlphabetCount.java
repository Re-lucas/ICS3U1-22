import java.util.Scanner;

public class AlphabetCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text (lower-case alphabets only): ");
        String input = scanner.nextLine();

        // Declare an array of size 26 to count the number of times each letter occurs
        int[] occurrences = new int[26];

        // Count the number of times each letter appears
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            //after got the index of it, than mins 'a' to finds in alphabet order
            occurrences[currentChar - 'a']++;
        }

        int maxOccurrences = occurrences[0];
        char mostFrequentChar = ' ';
        
        // Find the letter with the most occurrences
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > maxOccurrences) {
                //checkign the highest;
                maxOccurrences = occurrences[i];

                //do the backward by ASCII code parttern, and i represent the character in alphabet order(a, b, c...)
                mostFrequentChar = (char) ('a' + i);
            }
        }

        // output result
        System.out.println("The most frequent alphabet is: " + mostFrequentChar);
        System.out.println("Occurrences: " + maxOccurrences);

        scanner.close();
    }
}
