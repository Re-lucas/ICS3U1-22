import java.util.Scanner;

public class AddPairs{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a String of number: ");
        String input = myScanner.next();
        int sum = 0;

        for (int i = 0; i < input.length(); i += 2) {
            int firstDigit = input.charAt(i) - '0' ;


            int secondDigit = 0;

            if(i + 1 < input.length() ){
                secondDigit = input.charAt(i + 1) - '0';
            }

            int twoDigitNumber = firstDigit * 10 + secondDigit; 
            sum += twoDigitNumber;

            
        }

        System.out.println("The sum of two String of number are: " + sum);
        
        myScanner.close();

    }
}
    