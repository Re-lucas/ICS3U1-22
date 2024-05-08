import java.util.Scanner;

public class AddDigits{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        String input = myScanner.nextLine();
        int sum = 0;

        //by using a chatAt() method to loop over each number
        for (int i = 0; i < input.length(); i++){
            char digitChar = input.charAt(i); //get the current number
            int digit = Character.getNumericValue(digitChar);//the method can convert char into digit

            //there is another method by no using getNumbericValue() 
            //int digit = digitChar - '0' ;

            //In here because teh digitChar of the number which is not the actual number, but the partern in ASCI code was in partern, so we can mins '0' which is same as mins the asci code of 0;
             
            sum += digit;
        }

        System.out.println("The number of the sum is: " + sum);

        myScanner.close();
    }
}