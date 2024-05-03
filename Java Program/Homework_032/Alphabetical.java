import java.util.Scanner;

public class Alphabetical {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String firstString = myScanner.nextLine();

        System.out.println("Enter the first string:");
        String secondString = myScanner.nextLine();

        int comparisonResult = firstString.compareTo(secondString);

        if (comparisonResult < 0) {
            System.out.println("\"" + firstString + "\" is alphabetically before \"" + secondString + "\".");
        } else if (comparisonResult > 0) {
            System.out.println("\"" + firstString + "\" is alphabetically after \"" + secondString + "\".");
        } else {
            System.out.println("\"" + firstString + "\" is equal to \"" + secondString + "\".");
        }

        myScanner.close();
    }
    
}
