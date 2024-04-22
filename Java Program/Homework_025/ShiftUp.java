import java.util.Scanner;

public class ShiftUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter the number of " + (i + 1) + " numbers：");
            numbers[i] = scanner.nextInt();
        }
        

        int firstElement = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length - 1] = firstElement;
        

        System.out.println("Moved：");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}
