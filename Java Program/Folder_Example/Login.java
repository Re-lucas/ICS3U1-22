import java.util.Scanner;

public class Login{
   public static void main(String[] args){
      Scanner myScanner = new Scanner(System.in);
   
      final int user_password = 348905555;
      int password_check;
   

      System.out.print("Please enter your password: "); 
      password_check = myScanner.nextInt();

      if(password_check == user_password){
        System.out.println("Login Successfully");

      } else if (password_check != user_password ) {
        System.out.println("Login Unsuccessfully");

      }

      myScanner.close();

   }
}