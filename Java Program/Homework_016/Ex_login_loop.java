import java.util.Scanner;

public class Ex_login_loop {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int password = 299792;
        int password_enter;

        do {
            System.out.println("Enter password: ");
            password_enter = myScanner.nextInt();
        } while (password != password_enter);

        System.out.println("Login successful");
        myScanner.close();
    }
}
