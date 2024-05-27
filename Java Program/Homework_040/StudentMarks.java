import java.io.*;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        // a. Declare and create a 2D array to store the scores of 5 tests for each of 10 students
        int[][] marks = new int[10][5];

        // b. Read input from a text file “marks.txt” to fill in the array
        try (Scanner scanner = new Scanner(new File("marks.txt"))) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    if (scanner.hasNextInt()) {
                        marks[i][j] = scanner.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: marks.txt");
            return;
        }

        double[] studentAverages = new double[10];
        double highestAverage = 0;
        int topStudent = 0;

        // c. Calculate the average of the five tests for each student, and output the results to the file “result.txt”
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
            writer.write("Student averages:\n");

            for (int i = 0; i < 10; i++) {
                double sum = 0;
                for (int j = 0; j < 5; j++) {
                    sum += marks[i][j];
                }
                studentAverages[i] = sum / 5;
                writer.write("Student " + (i + 1) + ": " + studentAverages[i] + "\n");

                // d. Find out the student with the highest overall average
                if (studentAverages[i] > highestAverage) {
                    highestAverage = studentAverages[i];
                    topStudent = i + 1;
                }
            }

            writer.write("\nStudent with the highest overall average: Student " + topStudent + "\n");

            // e. Calculate the class average of each test and output the result to file “result.txt”
            writer.write("\nClass averages for each test:\n");
            for (int j = 0; j < 5; j++) {
                double testSum = 0;
                for (int i = 0; i < 10; i++) {
                    testSum += marks[i][j];
                }
                double testAverage = testSum / 10;
                writer.write("Test " + (j + 1) + ": " + testAverage + "\n");
            }

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
        }
    }
}
