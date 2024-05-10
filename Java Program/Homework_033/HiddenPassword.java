import java.util.Scanner;

public class HiddenPassword {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = myScanner.nextLine();
        System.out.print("Enter a character: ");
        char replacement = myScanner.next().charAt(0);

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ' ') {
                System.out.print(" "); // 输出空格
            } else {
                System.out.print(replacement); // 输出替换字符
            }
        }

        myScanner.close();
    }
}

