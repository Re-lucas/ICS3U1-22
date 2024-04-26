import java.util.Scanner;

public class DayCounter_Practice {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        final int CONDITION = -1;

        int days = 0;
        int count = 0;
        int num_practice = 0;
        int num_day = 0;

        System.out.println("Enter the practice, -1 to indicate no practice:");
        num_day = myScanner.nextInt();
        num_practice = num_day;

        while (num_day != CONDITION) {
            System.out.println("Enter practice time:");
            count++;

            if (num_day < num_practice) {
                num_practice = num_day;
                days = count;
            }

            num_day = myScanner.nextInt();  // 读取下一个输入
        }

        System.out.println("Days " + days + ": " + num_practice + " are the shortest.");
        System.out.println("You practice " + days + " in a row.");

        myScanner.close();
    }
}
