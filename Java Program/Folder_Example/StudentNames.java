import java.util.Scanner;

public class StudentNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] studentNames = new String[10];
        
        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
        }
        
        scanner.close();
        
        // Print out the student names
        System.out.println("Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
