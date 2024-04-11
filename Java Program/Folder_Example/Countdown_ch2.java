import java.util.Scanner;

public class Countdown_ch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int num = scanner.nextInt();

        for (int i = num; i >= 1; i--) {
            System.out.println(i);
        }

        scanner.close();
    }
}
