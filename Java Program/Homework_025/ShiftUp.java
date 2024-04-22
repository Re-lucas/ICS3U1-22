import java.util.Scanner;

public class ShiftUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个整数：");
            numbers[i] = scanner.nextInt();
        }
        

        int firstElement = numbers[0];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length - 1] = firstElement;
        

        System.out.println("移动后的数组：");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}
