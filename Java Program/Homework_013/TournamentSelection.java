/*
	File Name: TournamentSelection.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description:  Each player in a tournament plays six games. 
    There are no ties. The tournament director places the players in groups based 
    on the results of games as follows: 
    • if a player wins 5 or 6 games, they are placed in Group 1
    • if a player wins 3 or 4 games, they are placed in Group 2
    • if a player wins 1 or 2 games, they are placed in Group 3
    • if a player does not win any games, they are eliminated from the 
    tournament. 

    Write a program to determine which group a player is placed in. The input 
    consists of six lines, each with one of two possible characters: W to indicate a 
    win, L to indicate a loss. The program will then output which group the player 
    should be placed or if the player has been eliminated. (CCC 2016 J1)
*/

import java.util.Scanner;

public class TournamentSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wins = 0;

        System.out.println("Enter the results of the six games (W for win, L for loss):");
        for (int i = 0; i < 6; i++) {
            String result = scanner.nextLine();
            if (result.equals("W")) {
                wins++;
            }
        }

        if (wins == 5 || wins == 6) {
            System.out.println("Group 1");
        } else if (wins == 3 || wins == 4) {
            System.out.println("Group 2");
        } else if (wins == 1 || wins == 2) {
            System.out.println("Group 3");
        } else {
            System.out.println("Eliminated from the tournament");
        }

        scanner.close();
    }
}
