import java.util.Scanner;

public class ReadingInput {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner myObj = new Scanner(System.in);

        // Prompt the user to enter their first name
        System.out.println("Enter your first name");
        String Name_first = myObj.nextLine(); // Read the user's first name

        // Prompt the user to enter their last name
        System.out.println("Enter your last name");
        String Name_last = myObj.nextLine(); // Read the user's last name

        // Declare a variable to store the user's age
        int user_age;
        // Prompt the user to enter their age
        System.out.println("Enter your age");
        user_age = myObj.nextInt(); // Read the user's age

        // Declare a variable to store the user's height
        double user_height;
        // Prompt the user to enter their height (in centimeters)
        System.out.println("Enter your height (cm)");
        user_height = myObj.nextDouble(); // Read the user's height

        // Display the user's full name
        System.out.println("Your Name is: " + Name_first + " " + Name_last);
        // Display the user's age
        System.out.println("Your age is: " + user_age);
        // Display the user's height
        System.out.println("Your height is: " + user_height + " cm");
        
        myObj.close();

    }
}
