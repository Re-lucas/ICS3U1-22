import java.util.Scanner;

public class TennisMatchScorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] scoreTable = new int[5][2]; // 5 sets, 2 players

        // Prompt user for the score of each set and fill in the array
        for (int set = 0; set < 5; set++) {
            System.out.print("Enter the number of games won by player 1 in set " + (set + 1) + ": ");
            scoreTable[set][0] = scanner.nextInt();

            System.out.print("Enter the number of games won by player 2 in set " + (set + 1) + ": ");
            scoreTable[set][1] = scanner.nextInt();
        }

        // Calculate total games won by player 2
        int totalGamesPlayer2 = 0;
        for (int set = 0; set < 5; set++) {
            totalGamesPlayer2 += scoreTable[set][1];
        }

        // Calculate number of sets won by player 1
        int setsWonByPlayer1 = 0;
        for (int set = 0; set < 5; set++) {
            if (scoreTable[set][0] > scoreTable[set][1]) {
                setsWonByPlayer1++;
            }
        }

        // Output results
        System.out.println("Total games won by player 2: " + totalGamesPlayer2);
        System.out.println("Sets won by player 1: " + setsWonByPlayer1);

        scanner.close();
    }
}
