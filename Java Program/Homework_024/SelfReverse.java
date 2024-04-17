import java.util.Scanner;

public class SelfReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] list1 = new int[n];
        int[] list2 = new int[n];

        // Fill list1 with user input
        System.out.println("Enter " + n + " numbers for list1:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            list1[i] = scanner.nextInt();
        }

        // Reverse list1 into list2
        for (int i = 0; i < n; i++) {
            list2[i] = list1[n - 1 - i];
        }

        // Output the results
        System.out.println("\nlist1:");
        for (int number : list1) {
            System.out.print(number + " ");
        }

        System.out.println("\nlist2 (reversed):");
        for (int number : list2) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}
