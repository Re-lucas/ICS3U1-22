import java.util.Scanner;

public class MakeUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        //loop for every char
        for (int i = 0; i < input.length(); i++) {
            //initilize an char for comparing
            char character = input.charAt(i);

            //set the range which needs to be convert
            if (character >= 'a' && character <= 'z') {

                //because the ASCII code, so we first mins a and plus A
                //Example: if a is number 78 (assuming) than the letter b is 79
                //after mins a, left 1 and plus the A to get into to the parttern
                character = (char)(character - 'a' + 'A');

                //Ouput each one after converted
                System.out.print(character);
            }else{
                //if not in the range just output
                System.out.print(input.charAt(i));
            }
        }
        scanner.close();
    }
}
