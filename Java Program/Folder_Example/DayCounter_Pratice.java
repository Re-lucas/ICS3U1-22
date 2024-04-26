import java.util.Scanner;

public class DayCounter_Pratice{
    public void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        final int CONDITION = 0;

        int days = 0;
        int count = 0;
        int num_pratice = 0;
        int num_day = 0;

        System.out.println("Enter the pratice , -1 to indicate no practive:");
        num_day = myScanner.nextInt();
        num_pratice = num_day;

        while(num_day!= CONDITION){
            System.out.println("Enter pratice time:");
            count ++;

            if (num_day < num_pratice) {
                num_pratice = num_day;
                days = count;
            }
        }

        System.out.println("Days" + days + ":" + num_pratice + "are the shortest.");
        System.out.println("You pratice" + days + "in a row");

        myScanner.close();
    }
}