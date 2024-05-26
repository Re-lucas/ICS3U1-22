import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReverseLines {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("reverse.txt"))) {
            int numberOfLines = Integer.parseInt(reader.readLine().trim());
            ArrayList<String> lines = new ArrayList<>();

            for (int i = 0; i < numberOfLines; i++) {
                lines.add(reader.readLine());
            }

            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
