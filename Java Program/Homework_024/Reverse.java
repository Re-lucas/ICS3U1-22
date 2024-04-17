import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] list1 = new int[10];
        int[] list2 = new int[10];

        // Fill list1 with user input
        System.out.println("Enter 10 numbers for list1:");
        for (int i = 0; i < list1.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            list1[i] = scanner.nextInt();
        }

        // Reverse list1 into list2
        for (int i = 0; i < list1.length; i++) {
            list2[i] = list1[list1.length - 1 - i];
        }

        // Output the results
        System.out.println("\nlist1: ");
        for (int number : list1) {
            System.out.print(number + " ");
        }

        System.out.println("\nlist2 (reversed): ");
        for (int number : list2) {
            System.out.print(number + " ");
        }
        
        scanner.close();
    }
}
