import java.util.Scanner;

public class ClockAngle {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        int hour = 0;
        int minute = 0;

        System.out.println("Enter the hour: ");
        hour = myScanner.nextInt();

        System.out.println("Enter the mins: ");
        minute = myScanner.nextInt();


        // Because clock only has 12; and every minute is 0.5 degrees (360 degree divided by 12 hour and 60 min )
        double hourAngle = (hour % 12) * 30 + (minute * 0.5);

        //the same way but getting the min hands of angle
        double minuteAngle = minute * 6;

        // Used abs to get the angle
        double angle = Math.abs(hourAngle - minuteAngle);
        angle = Math.min(angle, 360 - angle); 

        System.out.println("The angle between the hour and minute hands is：" + angle + "°");

        myScanner.close();
    }
}
