import java.util.Scanner;

public class CountInt2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; 
        int userInput; 

        do {
            System.out.print("Please enter a interger（Enter any negative number to stop）：");
            userInput = input.nextInt();

            if (userInput >= 0) {
                count++;
            }
        } while (userInput >= 0);

        System.out.println("the total input are ：" + count);
        
        input.close();
    }
}
