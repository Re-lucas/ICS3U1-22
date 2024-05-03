import java.util.Scanner;

public class Half {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int middle = input.length() / 2;//Because cut it on half which is the half of input.length();
        String firstHalf = input.substring(0, middle); //By sub teh first half into the string
        String secondHalf = input.substring(middle);//The second half

        System.out.println("First half: " + firstHalf);
        System.out.println("Second half: " + secondHalf);

        scanner.close();
    }
}
