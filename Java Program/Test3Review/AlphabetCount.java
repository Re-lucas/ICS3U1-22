import java.util.Scanner;

public class AlphabetCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line of text (lower-case alphabets only): ");
        String input = scanner.nextLine();

        // 声明一个大小为26的数组，用于统计每个字母出现的次数
        int[] occurrences = new int[26];

        // 统计每个字母出现的次数
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            occurrences[currentChar - 'a']++;
        }

        // 找到出现次数最多的字母
        int maxOccurrences = 0;
        char mostFrequentChar = ' ';
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > maxOccurrences) {
                maxOccurrences = occurrences[i];
                mostFrequentChar = (char) ('a' + i);
            }
        }

        // 输出结果
        System.out.println("The most frequent alphabet is: " + mostFrequentChar);
        System.out.println("Occurrences: " + maxOccurrences);

        scanner.close();
    }
}
