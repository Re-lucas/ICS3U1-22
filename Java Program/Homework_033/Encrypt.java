import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = myScanner.nextLine();
        
        //By using the String array to indicates that we need to split the string enter by user
        // and also because we are comparing each of char, so using the String array to get index
        String[] characters = input.split("");
        
        // get the first index [0] of array  element
        char firstChar = characters[0].charAt(0);
        // get the characters[characters.length - 1].charAt(0);
        char lastChar = characters[characters.length - 1].charAt(0);
        
        // print out the last char
        System.out.print(lastChar);
        
        // and the middle part of it move 2 positive in ACII
        // the one not include index 0 and characters.length - 1;
        for (int i = 1; i < characters.length - 1; i++) {
            //Gets the first character of the currently traversed string element.
            char c = characters[i].charAt(0);

            //by checking if the char is empty or not 
            if (c != ' ') {
                System.out.print((char) (c + 2));
            } else {
                System.out.print(' '); // space stay same
            }
        }
        
        // characters.length - 1;
        System.out.println(firstChar);

        myScanner.close();
    }
}
