import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestLine {
    public static void main(String[] args) {
        String fileName = "data.txt";
        String longestLine = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read the first line to get the number of lines that follow
            String line = reader.readLine();
            int numLines = Integer.parseInt(line);

            // Initialize variable to store the length of the longest line
            int maxLength = 0;

            // Iterate through the remaining lines and find the longest one
            for (int i = 0; i < numLines; i++) {
                line = reader.readLine();
                if (line.length() > maxLength) {
                    maxLength = line.length();
                    longestLine = line;
                }
            }

            // Output the longest line
            System.out.println(longestLine);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
