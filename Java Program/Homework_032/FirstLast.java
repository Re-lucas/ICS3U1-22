import java.util.Scanner;

public class FirstLast {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String input = myScanner.nextLine();

        if (input.length() > 0) {
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);

            System.out.println("First character: " + firstChar);
            System.out.println("Last character: " + lastChar);
        } else {
            System.out.println("The string is empty.");
        }

        myScanner.close();
    }
    
}
