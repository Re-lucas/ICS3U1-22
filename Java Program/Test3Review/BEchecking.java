import java.util.Scanner;

public class BEchecking {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a line of text: ");
        String input = myScanner.nextLine();

        String[] characters = input.split("");

        for(int i = 0; i < characters.length; i++ ){
            if (characters[i].equals(characters[characters.length - 1])) {
                System.out.println(characters[i]);
            }
        }

        myScanner.close();
    }
    
}
