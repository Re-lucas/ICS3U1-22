import java.util.Scanner;

public class SilentAuction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of bids
        System.out.print("Enter the number of bids collected: ");
        int N = scanner.nextInt();

        // Initialize variables to keep track of the highest bid and winner
        int highestBid = Integer.MIN_VALUE;
        String winner = "";

        // Read N pairs of lines containing name and bid
        for (int i = 0; i < N; i++) {
            scanner.nextLine(); // Consume newline
            String name = scanner.nextLine();
            int bid = scanner.nextInt();

            // Update highestBid and winner if the current bid is higher
            if (bid > highestBid) {
                highestBid = bid;
                winner = name;
            }
        }

        // Print the winner
        System.out.println(winner);

        scanner.close();
    }
}
