import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a string to be reversed: ");
        String input = myScanner.nextLine();

        //is reversed which is loop from the last one and backward
        for (int i = input.length() - 1 ; i >= 0; i--){
            System.out.print(input.charAt(i));
        }

        myScanner.close();

    }
}
