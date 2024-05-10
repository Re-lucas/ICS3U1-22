import java.util.Scanner;

public class Random{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);


        System.out.print("Enter two integers (a, b): ");
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();
        int randomNumber = a + (int) (Math.random() * ((b - a) + 1));
        System.out.println("Random number between " + a + " and " + b + ": " + randomNumber);

        myScanner.close();

    }
}