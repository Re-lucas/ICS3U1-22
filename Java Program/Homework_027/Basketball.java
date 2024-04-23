public class Basketball {
    public static void main(String[] args) {
        int[][] scores = {
            {10, 20, 30, 40, 50}, // Team 0 scores
            {15, 25, 35, 45, 55}  // Team 1 scores
        };

        int totalPointsTeam0 = 0;
        int totalPointsTeam1 = 0;
        int winsTeam0 = 0;
        int winsTeam1 = 0;

        for (int game = 0; game < scores[0].length; game++) {
            totalPointsTeam0 += scores[0][game];
            totalPointsTeam1 += scores[1][game];

            if (scores[0][game] > scores[1][game]) {
                winsTeam0++;
            } else if (scores[1][game] > scores[0][game]) {
                winsTeam1++;
            }
        }

        System.out.println("Team 0 total: " + totalPointsTeam0);
        System.out.println("Team 1 total: " + totalPointsTeam1);
        System.out.println("Team 0 the times of win: " + winsTeam0);
        System.out.println("Team 1 the times of win: " + winsTeam1);
    }
}
