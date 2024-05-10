import java.util.Scanner;

public class WordChecker {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a long text: ");
        String input = myScanner.nextLine();

        // Split the input string into an array of words using space as the delimiter
        String[] words = input.split("\\s+");

        // Check each word and print if the first and last characters are the same
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if (word.length() > 1 && word.charAt(0) == word.charAt(word.length() - 1)) {
                System.out.println(word);
            }
        }

        myScanner.close();
    }
}
