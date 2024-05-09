import java.util.Scanner;

public class Divide17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数字：");
        String firstNumber = scanner.next();
        System.out.print("请输入第二个数字：");
        String secondNumber = scanner.next();

        // 使用 substring 方法合并两个数字
        String combinedNumberString = firstNumber + secondNumber;
        double combinedNumber = Double.parseDouble(combinedNumberString);

        // 计算新数字除以17的结果
        double result = combinedNumber / 17;

        // 输出结果，保留两位小数
        System.out.printf("新数字除以17的结果（保留两位小数）：%.2f%n", result);

        scanner.close();
    }
}
