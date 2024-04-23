import java.util.Scanner;

public class AllArrays3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task a: Ask user to enter the number of students and the number of tests
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter the number of tests: ");
        int numTests = scanner.nextInt();

        // Initialize a 2D array to store test marks
        double[][] testMarks = new double[numStudents][numTests];

        // Task b: Ask user to enter each test mark for all students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter test marks for student " + (i + 1) + ":");
            for (int j = 0; j < numTests; j++) {
                System.out.print("Test " + (j + 1) + ": ");
                testMarks[i][j] = scanner.nextDouble();
            }
        }

        // Task c: Calculate and output the average of each student
        System.out.println("\nAverage marks for each student:");
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numTests; j++) {
                sum += testMarks[i][j];
            }
            double average = sum / numTests;
            System.out.println("Student " + (i + 1) + ": " + String.format("%.2f", average));
        }

        // Task d: Output the student with the highest average
        double highestAverage = Double.MIN_VALUE;
        int highestAverageStudent = -1;
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numTests; j++) {
                sum += testMarks[i][j];
            }
            double average = sum / numTests;
            if (average > highestAverage) {
                highestAverage = average;
                highestAverageStudent = i;
            }
        }
        System.out.println("\nStudent with the highest average: Student " + (highestAverageStudent + 1));

        // Task e: List students whose average is higher than the class average
        double classAverage = 0;
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numTests; j++) {
                sum += testMarks[i][j];
            }
            classAverage += sum;
        }
        classAverage /= (numStudents * numTests);

        System.out.println("Students with an average higher than the class average:");
        for (int i = 0; i < numStudents; i++) {
            double sum = 0;
            for (int j = 0; j < numTests; j++) {
                sum += testMarks[i][j];
            }
            double average = sum / numTests;
            if (average > classAverage) {
                System.out.println("Student " + (i + 1));
            }
        }

        scanner.close();
    }
}
