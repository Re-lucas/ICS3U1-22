import java.util.Scanner;

public class CountInt1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; 
        int userInput; 

        do {
            System.out.print("Please enter a interger（-1 for end）：");
            userInput = input.nextInt();

            if (userInput != -1) {
                count++;
            }
        } while (userInput != -1);

        System.out.println("the total input are ：" + count);
        
        input.close();
    }
}
