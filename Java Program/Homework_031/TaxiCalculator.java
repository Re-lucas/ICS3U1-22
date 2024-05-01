import java.util.Scanner;

public class TaxiCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int totalPassengers = 0; // Replace with the actual number of passengers

        System.out.println("Enter the number of passengers:");
        totalPassengers = myScanner.nextInt();


        // Calculate the number of taxis needed
        int taxisRequired = (totalPassengers + 3) / 4;

        System.out.println("Total passengers: " + totalPassengers);
        System.out.println("Taxis required: " + taxisRequired);

        myScanner.close();
    }
}
