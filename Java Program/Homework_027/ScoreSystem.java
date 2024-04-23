import java.util.Scanner;

public class ScoreSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // The num of judge and player
        System.out.print("Number of players：");
        int playerCount = scanner.nextInt();
        System.out.print("Number of judges：");
        int judgeCount = scanner.nextInt();

        // initialize the chat of player and their scores
        String[] playerNames = new String[playerCount];
        double[][] scores = new double[playerCount][judgeCount];

        // Enter their name and the score relate to them
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Please enter the name of " + (i + 1) + " ：");
            playerNames[i] = scanner.next();
            for (int j = 0; j < judgeCount; j++) {
                System.out.print("Please enter number " + (j + 1) + " judge's " + playerNames[i] + " score：");
                scores[i][j] = scanner.nextDouble();
            }
        }

        
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

    
        System.out.println("\nPlayer's scores：");
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Number" + (i + 1) + "：" + playerNames[i] + "，final score：" + finalScores[i]);
        }

        scanner.close();
    }
}
