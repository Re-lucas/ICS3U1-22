import java.util.Scanner;

public class MakeUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (character >= 'a' && character <= 'z') {
                character = (char)(character - 'a' + 'A');
                System.out.print(character);
            }else{
                System.out.print(input.charAt(i));
            }
        }
        scanner.close();
    }
}
