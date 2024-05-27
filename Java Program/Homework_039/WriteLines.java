import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("writeLines.txt"))) {
            // Prompt the user to enter 10 lines of text
            System.out.println("Please enter 10 lines of text:");
            
            for (int i = 1; i <= 10; i++) {
                System.out.print("Line " + i + ": ");
                String line = scanner.nextLine();
                writer.write(line);
                writer.newLine();
            }
            
            System.out.println("All lines have been written to writeLines.txt successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        } finally {
            scanner.close();
        }
    }
}
