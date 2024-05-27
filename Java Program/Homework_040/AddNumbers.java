import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AddNumbers {
    public static void main(String[] args) {
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Integer.parseInt(line.trim());
            }
            System.out.println("Sum: " + sum);
        } catch (IOException e) {
            System.out.println("Error message.");
        }
    }
}
