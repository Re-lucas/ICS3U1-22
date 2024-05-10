import java.util.Scanner;

public class Random{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        //Random Number Between Two Integers
        System.out.print("Enter two integers (a, b): ");
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();

        //by using a + Math.random() * ((b - a) + 1)) to indicate the range include the b and a output a random number
        //example: b = 10 and a = 5; which is 5, if just time the thing and plus by a it will only include number 5 to a (10 - 1)
        //so we need the ((b - a) + 1))
        int randomNumber = a + (int) (Math.random() * ((b - a) + 1));

        System.out.println("Random number between " + a + " and " + b + ": " + randomNumber);

        myScanner.close();

    }
}