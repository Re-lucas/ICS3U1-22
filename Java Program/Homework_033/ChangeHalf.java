import java.util.Scanner;

public class ChangeHalf{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        String output;

        if(input.length() % 2 == 0){
            int middle = input.length()/2;
            output = input.substring(middle) + input.substring(0, middle);
            
        }
        myScanner.close();
    }
}