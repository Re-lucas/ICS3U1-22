import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintAllChar {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("allChar.txt"))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch != ' ' && ch != '\n' && ch != '\r') {
                    System.out.println((char) ch);
                }
            }
        } catch (IOException e) {
            System.out.println("Error message.");
        }
    }
}
