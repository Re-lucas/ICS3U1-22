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

    public static String reverseString(String string){
        String input = string;
        String newString = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));

            newString += newString + string.charAt(i);
        }

        return newString;
    }
}
