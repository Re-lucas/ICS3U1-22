import java.util.Scanner;

public class Ex_login_loop_2 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int password = 299792;
        int password_enter;
        final int MAX_TRY = 3;
        int tryCount = 0;
        boolean loginSuccessful = false;

        do {
            System.out.println("Enter password: ");
            password_enter = myScanner.nextInt();
            tryCount++;

            if (password_enter == password) {
                loginSuccessful = true;
            }
        } while (!loginSuccessful && tryCount < MAX_TRY);

        if (loginSuccessful) {
            System.out.println("Login successful");
        } else {
            System.out.println("Maximum attempts reached. Login failed.");
        }

        myScanner.close();
    }
}
