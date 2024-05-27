import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StarTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the dimension of the table: ");
        int dimension = scanner.nextInt();
        
        // Create and initialize a 2D array of characters with the specified dimensions
        char[][] starTable = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                starTable[i][j] = '*';
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("star.txt"))) {
            // Write the content of the array as a table to the file
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    writer.write(starTable[i][j]);
                    writer.write(' '); // Add a space for better readability
                }
                writer.newLine(); // Move to the next line after each row
            }
            
            System.out.println("Star table written to star.txt successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        } finally {
            scanner.close();
        }
    }
}
