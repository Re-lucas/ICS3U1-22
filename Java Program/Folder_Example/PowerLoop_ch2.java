import java.util.Scanner;

public class PowerLoop_ch2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int i = num;
        int count = 1;
        while (i <= 1000000) {
            System.out.println(i);
            i *= num;
            count++;
        }
        System.out.println("Number of times loop was executed: " + (count - 1));

        scanner.close();
    }
}
