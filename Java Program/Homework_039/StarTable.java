import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StarTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the dimensions of the table:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[][] table = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                table[i][j] = '*';
            }
        }

        try (FileWriter writer = new FileWriter("star.txt")) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(table[i][j] + " ");
                }
                writer.write(System.lineSeparator());
            }
            System.out.println("Star table has been written to star.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
