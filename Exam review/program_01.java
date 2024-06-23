import java.util.Scanner;

public class program_01{
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        final int CONDITION_01 = -1;
        boolean condition = true;
        int min;
        int day = 1;

        System.out.println("Enter day " + day);
        min = myScanner.nextInt();

        if(min == CONDITION_01){
            condition = false;
            System.out.println("No valid input received.");
        } else {
            do {
                day++;
                System.out.println("Enter day " + day);
                int co_min = myScanner.nextInt();

                if(co_min == CONDITION_01){
                    condition = false;
                } else {
                    if(co_min < min){
                        min = co_min;
                    }
                }
            } while(condition);

            System.out.println("The day of practice is: " + (day - 1));
            System.out.println("The shortest is: " + min);
        }

        myScanner.close();
    }
}
