import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter("writeChars.txt")) {
            while (true) {
                System.out.println("Please enter a line of text (type 'stop' to end):");
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("stop")) {
                    break;
                }
                for (char ch : line.toCharArray()) {
                    writer.write(ch + System.lineSeparator());
                }
                writer.write(System.lineSeparator()); // Blank line to separate sets of characters
            }
            System.out.println("Characters have been written to writeChars.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
