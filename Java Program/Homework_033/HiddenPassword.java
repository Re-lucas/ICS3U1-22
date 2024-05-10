import java.util.Scanner;

public class HiddenPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter a character: ");
        char replacement = scanner.next().charAt(0);

        for(int i = 0; i < input.length(); i++){
            String[] comparing = input.charAt(i);

            if(comparing[i] == ""){
                System.out.print("");
            }else{
                System.out.print(replacement);
            }
        }
    }
}
