import java.util.Scanner;

public class HiddenPassword {
    public static void main(String[] args) {

        //Get the user's string and the char wants to replace
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = myScanner.nextLine();
        System.out.print("Enter a character: ");
        char replacement = myScanner.next().charAt(0);

        //using for loop to go over every char in the string,s so i < input.length();
        for (int i = 0; i < input.length(); i++) {
            //char does not allow to compare with string, convert each index in the string into char
            char currentChar = input.charAt(i);

            //check the situation if it is '' (space) or not
            if (currentChar == ' ') {
                System.out.print(" "); // 输出空格
            } else {
                System.out.print(replacement); // 输出替换字符
            }
        }

        myScanner.close();
    }
}

