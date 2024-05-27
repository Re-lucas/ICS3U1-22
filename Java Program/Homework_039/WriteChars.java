import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("writeChars.txt"))) {
            String input;
            
            while (true) {
                System.out.print("Enter a line of text (or type 'stop' to finish): ");
                input = scanner.nextLine();
                
                if ("stop".equalsIgnoreCase(input)) {
                    break;
                }
                
                // Write each character of the input line to the file on separate lines
                for (char ch : input.toCharArray()) {
                    writer.write(ch);
                    writer.newLine();
                }
                
                // Add a blank line to separate sets of characters from each line
                writer.newLine();
            }
            
            System.out.println("All characters have been written to writeChars.txt successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        } finally {
            scanner.close();
        }
    }
}
