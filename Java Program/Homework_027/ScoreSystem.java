import java.util.Scanner;

public class ScoreSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入选手人数和评委人数
        System.out.print("请输入选手人数：");
        int playerCount = scanner.nextInt();
        System.out.print("请输入评委人数：");
        int judgeCount = scanner.nextInt();

        // 初始化选手姓名和评分表
        String[] playerNames = new String[playerCount];
        double[][] scores = new double[playerCount][judgeCount];

        // 输入选手姓名和评分
        for (int i = 0; i < playerCount; i++) {
            System.out.print("请输入第 " + (i + 1) + " 位选手的姓名：");
            playerNames[i] = scanner.next();
            for (int j = 0; j < judgeCount; j++) {
                System.out.print("请输入第 " + (j + 1) + " 位评委给 " + playerNames[i] + " 的评分：");
                scores[i][j] = scanner.nextDouble();
            }
        }

        // 计算选手的最终得分
        double[] finalScores = new double[playerCount];
        for (int i = 0; i < playerCount; i++) {
            double sum = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            for (int j = 0; j < judgeCount; j++) {
                sum += scores[i][j];
                max = Math.max(max, scores[i][j]);
                min = Math.min(min, scores[i][j]);
            }
            finalScores[i] = (sum - max - min) / (judgeCount - 2);
        }

        // 输出选手得分信息
        System.out.println("\n选手得分信息：");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("选手" + (i + 1) + "：" + playerNames[i] + "，最终得分：" + String.format("%.2f", finalScores[i]));
        }

        scanner.close();
    }
}
