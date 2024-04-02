import java.util.Scanner;

public class Continue {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        char user_input;
        final char CONDITION_YES = 'y'; 
        final char CONDITION_NO = 'n'; 

        do{
            System.out.println("Continue? Respond with y or n");
            user_input = myScanner.next().charAt(0);

            if (user_input == CONDITION_YES) {
                System.out.println("Thanks");
            }
        }while(user_input != CONDITION_NO);

        myScanner.close();

    }
    
}
