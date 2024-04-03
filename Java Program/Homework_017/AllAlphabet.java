public class AllAlphabet {
    public static void main(String[] args) {
        char letter = 'a'; // Initialize the starting character 'a'

        // Loop through the alphabet and print each character
        while (letter <= 'z') {
            System.out.print(letter + " ");
            letter++; // Increment to the next character
        }

        // Print a newline after printing all characters
        System.out.println();
    }
}
