import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        int vowelCount = countVowels(input);
        System.out.println("Number of vowels: " + vowelCount);

        scanner.close();
    }

    private static int countVowels(String input) {
        int count = 0;
        // 将输入的字符串转换为小写字母，方便比较
        input = input.toLowerCase();
        // 遍历字符串中的每个字符，检查是否为元音字母
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
