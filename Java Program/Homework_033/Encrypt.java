import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a line to be encrypted: ");
        String input = myScanner.nextLine();
        
        // 使用 split("") 方法将字符串分割为字符数组
        String[] characters = input.split("");
        
        // 取得第一个字符
        char firstChar = characters[0].charAt(0);
        // 取得最后一个字符
        char lastChar = characters[characters.length - 1].charAt(0);
        
        // 输出最后一个字符
        System.out.print(lastChar);
        
        // 中间部分字符向后移动两位
        for (int i = 1; i < characters.length - 1; i++) {
            char c = characters[i].charAt(0);
            if (c != ' ') {
                System.out.print((char) (c + 2));
            } else {
                System.out.print(' '); // 空格保持不变
            }
        }
        
        // 输出第一个字符
        System.out.println(firstChar);

        myScanner.close();
    }
}
