import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        double user_input;
        double user_total = 0;
        final double CONDITION = 0;

        do{
            System.out.println("Please enter a number (when number are negative, it will stop):");
            user_input = myScanner.nextDouble();
            user_total += user_input;

        }while(user_input >= CONDITION);

        System.out.println("Total value is " + user_total);

        myScanner.close();
    }
}
