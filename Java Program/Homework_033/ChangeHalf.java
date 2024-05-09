import java.util.Scanner;

public class ChangeHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String output;

        //so we have two siuation:
        //if teh input.length() is even than just simply divide into two even part by 
        //.substring(0, middle) which is the part fron index zero to middle -1
        // and another part of .substring(middle) which start from middle (include middle) and the rest after.

        // second, if the input.length() is not even; 
        // than the middle char does not change which is input.length() / 2 ;
        // and the front of substring(0 , middle) and back substring(middle + 1) are changed place;



        // Check if the length of the string is even or odd
        if (input.length() % 2 == 0) {
            // If even, split the string in half and swap
            int middle = input.length() / 2;
            output = input.substring(middle) + input.substring(0, middle);
        } else {
            // If odd, leave the middle character in place
            int middle = input.length() / 2;
            output = input.substring(middle + 1) + input.charAt(middle) + input.substring(0, middle);
        }

        System.out.println("Output: " + output);

        scanner.close();
    }
}
