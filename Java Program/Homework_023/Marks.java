import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[4];
        int[] marks = new int[4];

        // a) Fill them with values from the user
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
            System.out.print("Enter mark for " + names[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline
        }

        // b) Prompt the user for one mark, search for it
        System.out.print("Enter a mark to search for: ");
        int searchMark = scanner.nextInt();
        boolean found = false;
        int i = 0;

        // Modified loop without break or continue
        while (i < marks.length && !found) {
            if (marks[i] == searchMark) {
                System.out.println("The mark " + searchMark + " was obtained by " + names[i]);
                found = true;
            }
            i++;
        }

        if (!found) {
            System.out.println("The mark " + searchMark + " doesn't exist.");
        }

        scanner.close();
    }
}
