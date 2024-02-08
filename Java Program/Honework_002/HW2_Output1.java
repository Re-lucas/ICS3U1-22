/*
	File Name: Output_Example_001.java
   Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 8, 2024
	Description: HW2_Output1.java
*/

 // A Java program to display a tic-tac-toe board with an X in the center
public class HW2_Output1{
 public static void main (String[] args){
        // Create a 2D array to store the board
        char [] [] board = new char [3] [3];

        // Fill the board with spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board [i] [j] = ' ';
            }
        }

        // Place an X in the center
        board [1] [1] = 'X';

        // Display the board
        printBoard (board);
    }

    // A method to print the board
    public static void printBoard (char [] [] board) {

        // Print the top border
        System.out.println ("| | | |");

        // Print each row of the board
        for (int i = 0; i < 3; i++) {

            // Print the left border
            System.out.print ("| ");

            // Print each cell of the row
            for (int j = 0; j < 3; j++) {
                System.out.print (board [i] [j] + " | ");
            }

            // Print a new line
            System.out.println ();

            // Print the bottom border
            System.out.println ("| | | |");
        }
    }
}

   }
}