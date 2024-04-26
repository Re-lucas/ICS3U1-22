import java.util.Scanner;

public class CheckprimeNum {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int m = 0;
        int n = 0;
        int count = 0;

        System.out.println("Enter 1st number:");
        m = myScanner.nextInt();

        System.out.println("Enter 2nd number:");
        n = myScanner.nextInt();

        for (int i = m; i <= n; i++) {
            boolean isPrime = true;

            // 检查 i 是否能被 j 整除，而不使用 break
            for (int j = 2; j <= Math.sqrt(i) && isPrime; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        System.out.println("There are " + count + " prime numbers in the range.");

        myScanner.close();
    }
}
