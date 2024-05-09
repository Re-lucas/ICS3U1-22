import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();

        for (String word : input.split(" ")) {
            if (word.length() > 2) {
                // 交换首尾字符
                char firstChar = word.charAt(0);
                char lastChar = word.charAt(word.length() - 1);
                String middle = word.substring(1, word.length() - 1);

                // 处理中间字符
                StringBuilder shiftedMiddle = new StringBuilder();
                for (char c : middle.toCharArray()) {
                    shiftedMiddle.append((char) (c + 2));
                }

                encrypted.append(lastChar).append(shiftedMiddle).append(firstChar);
            } else {
                // 如果字符串长度小于3，直接添加
                encrypted.append(word);
            }
            encrypted.append(" "); // 单词之间添加空格
        }

        // 移除最后一个多余的空格
        if (encrypted.length() > 0 && encrypted.charAt(encrypted.length() - 1) == ' ') {
            encrypted.deleteCharAt(encrypted.length() - 1);
        }

        System.out.println("The encryption is: " + encrypted.toString());

        scanner.close();
    }
}
