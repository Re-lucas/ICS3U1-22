// CarRental.java

import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declare and create three arrays of size 10
        int[] serialNum = new int[10];
        char[] type = new char[10];
        int[] mileage = new int[10];

        // Prompt user for information of each of the 10 cars and fill the arrays accordingly
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter serial number for car " + (i + 1) + ": ");
            serialNum[i] = scanner.nextInt();

            System.out.print("Enter type (E/S/P/L) for car " + (i + 1) + ": ");
            type[i] = scanner.next().charAt(0);

            System.out.print("Enter mileage for car " + (i + 1) + ": ");
            mileage[i] = scanner.nextInt();
        }

        // Calculate the average mileage driven by all cars
        int totalMileage = 0;
        for (int m : mileage) {
            totalMileage += m;
        }
        double averageMileage = (double) totalMileage / 10;

        // Output the serial numbers of all cars with mileage over the average
        System.out.println("Cars with mileage over the average:");
        for (int i = 0; i < 10; i++) {
            if (mileage[i] > averageMileage) {
                System.out.println("Serial number: " + serialNum[i]);
            }
        }

        // Prompt user for a type and output the serial numbers of all cars of that type
        System.out.print("Enter a type (E/S/P/L): ");
        char inputType = scanner.next().charAt(0);
        System.out.println("Serial numbers of cars with type " + inputType + ":");
        for (int i = 0; i < 10; i++) {
            if (type[i] == inputType) {
                System.out.println("Serial number: " + serialNum[i]);
            }
        }

        scanner.close();
    }
}
