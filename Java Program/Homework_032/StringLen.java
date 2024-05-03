import java.util.Scanner;


public abstract class StringLen {
    public static void main(String[] arg){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the String: ");

        String input = myScanner.nextLine();
        System.out.println("The string length of inout is: " + input.length());

        myScanner.close();
    }
    
}
