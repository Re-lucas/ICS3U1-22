import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (FileWriter writer = new FileWriter("writeLines.txt")) {
            System.out.println("Please enter 10 lines of text:");
            for (int i = 0; i < 10; i++) {
                String line = scanner.nextLine();
                writer.write(line + System.lineSeparator());
            }
            System.out.println("Lines have been written to writeLines.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
