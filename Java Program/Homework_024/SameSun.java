import java.util.Scanner;

public class SameSun {
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

        // Fill list2 such that the sum of corresponding cells with list1 is 25
        for (int i = 0; i < list2.length; i++) {
            list2[i] = 25 - list1[i];
        }

        // Output the results
        System.out.println("\nlist1: ");
        for (int number : list1) {
            System.out.print(number + " ");
        }

        System.out.println("\nlist2: ");
        for (int number : list2) {
            System.out.print(number + " ");
        }
        
        scanner.close();
    }
}
