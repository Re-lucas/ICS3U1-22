import java.util.Scanner;

public class NumberPresent {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a list of Numbers:");
        String input = myScanner.next();

        int[] arrays = new int[10];

        // 将输入的数字转换为数组中对应的位置加一
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (Character.isDigit(digit)) {
                arrays[digit - '0']++;
            }
        }

        boolean allPresent = true;

        // 检查数字0到9是否都出现在输入中
        System.out.println("Here are the not present numbers:");
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 0) {
                System.out.println(i);
                allPresent = false;
            }
        }

        if (allPresent) {
            System.out.println("All numbers are present.");
        }

        myScanner.close();
    }
}
