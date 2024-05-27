import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TimeTable {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("timetable.txt"))) {
            // Iterate through each row
            for (int i = 1; i <= 12; i++) {
                // Iterate through each column
                for (int j = 1; j <= 12; j++) {
                    writer.write(String.format("%4d", i * j)); // Write the product formatted to align columns
                }
                writer.newLine(); // New line after each row
            }
            System.out.println("Times table written to timetable.txt successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
