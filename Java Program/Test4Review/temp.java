import java.util.Scanner;

public class temp {

    //b) Complete main method in class Temp:
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to enter a Celsius temperature
        System.out.print("Enter a Celsius temp: ");
        double celsius = scanner.nextDouble();
        
        // Call the static method from class Conversions to convert Celsius to Fahrenheit
        double fahrenheit = Conversions.celsiusToFahrenheit(celsius);
        
        // Output the result
        System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
        
        scanner.close();
    }

    //a) Static method in class Conversions to convert Celsius to Fahrenheit:
    public class Conversions {
        public static double celsiusToFahrenheit(double celsius) {
            return (celsius * 9/5) + 32;
        }
    }
    
}
