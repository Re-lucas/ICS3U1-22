import java.util.Scanner;

public class FormatName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter firstname: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter lastname: ");
        String lastName = scanner.nextLine();
        

        // Create a new string in the format "Last Name, First Initial".
        String newFormat = lastName + ", " + firstName.charAt(0) + ".";
        
        System.out.println("The new name is: " + newFormat);

        scanner.close();
    }
}
