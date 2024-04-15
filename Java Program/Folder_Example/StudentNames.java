import java.util.Scanner;

public class StudentNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of Students: ");
        int numStudent = scanner.nextInt();

        String[] studentNames = new String[numStudent];
        
        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
        }
        
        scanner.close();
        

        System.out.println("Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
