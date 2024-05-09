import java.util.Scanner;

public class AddUnicodes {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a string: " );
        String input = myScanner.nextLine();

        int sum = 0;

         // Iterate over each character in the input string and add up their Unicode values
        for(int i = 0; i < input.length(); i++){
            //Direct conversion to ASCII using casting
            sum += (int) input.charAt(i);
        }

        System.out.println(sum);

        myScanner.close();
    }
}
