import java.util.Scanner;

public class Student{
    public static void main(String[] args){
        final int NUM_NAMES = 20;
        final int NUM_TESTS = 20;

        // a) Declare and create two arrays
        String[] names = new String[NUM_NAMES];
        float[][] marks = new float[NUM_NAMES][NUM_TESTS];

        // b) Prompt for the mark of each test
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_NAMES; i++) {
            for (int j = 0; j < NUM_TESTS; j++) {
                System.out.print("Enter the mark " + names[i] + " received in test " + (j + 1) + ": ");
                marks[i][j] = scanner.nextFloat();
            }
        }

        // c) Calculate and output the average of all tests of all students
        float total = 0;
        for (float[] studentMarks : marks) {
            for (float mark : studentMarks) {
                total += mark;
            }
        }
        float average = total / (NUM_NAMES * NUM_TESTS);
        System.out.println("Average mark: " + average);

        // d) Output the name of the student with the highest mark
        float highestMark = 0;
        String topStudent = "";
        for (int i = 0; i < NUM_NAMES; i++) {
            for (float mark : marks[i]) {
                if (mark > highestMark) {
                    highestMark = mark;
                    topStudent = names[i];
                }
            }
        }
        System.out.println("Top student: " + topStudent);

        // e) Prompt user for a student name and output the number of failed tests
        System.out.print("Enter a student name: ");
        String studentName = scanner.nextLine();
        boolean found = false;
        int failedTests = 0;
        for (int i = 0; i < NUM_NAMES; i++) {
            if (names[i].equals(studentName)) {
                found = true;
                for (float mark : marks[i]) {
                    if (mark < 50) {
                        failedTests++;
                    }
                }
            }
        }

        System.out.println(studentName + " failed " + failedTests + " tests.");

        if (!found) {
            System.out.println("Error: Student not found.");
        }

        scanner.close();

    }
}