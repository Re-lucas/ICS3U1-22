import java.util.Scanner;

public class ClockAngle {
    public static void main(String[] args) {
        Scanner myScanner = new
        
        int hour = 0;
        int minute = 0;

        System
        // 计算时针和分针的角度
        double hourAngle = (hour % 12) * 30 + (minute * 0.5);
        double minuteAngle = minute * 6;

        // 计算夹角
        double angle = Math.abs(hourAngle - minuteAngle);
        angle = Math.min(angle, 360 - angle); // 取最小夹角

        System.out.println("The angle between the hour and minute hands is：" + angle + "°");
    }
}
