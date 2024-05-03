import java.util.Scanner;

public class Half {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int middle = input.length() / 2;
        String firstHalf = input.substring(0, middle);
        String secondHalf = input.substring(middle);

        System.out.println("First half: " + firstHalf);
        System.out.println("Second half: " + secondHalf);

        scanner.close();
    }
}
