import java.util.Scanner;

public class Divide17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first num：");
        String firstNumber = scanner.next();
        System.out.print("Enter the second num：");
        String secondNumber = scanner.next();

        // by using substring
        String combinedNumberString = firstNumber + secondNumber;
        double combinedNumber = Double.parseDouble(combinedNumberString);

        // 计算新数字除以17的结果
        double result = combinedNumber / 17;

        // 输出结果，保留两位小数
        System.out.printf("The result of dividing the new number by 17 (retain two decimal places): %.2f%n", result);

        scanner.close();
    }
}
