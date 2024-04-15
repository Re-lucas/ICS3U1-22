import java.util.Scanner;

public class Height {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[20];
        double sum = 0;
        
        // Read in the heights
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height for person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        
        // Calculate the average height
        double average = sum / heights.length;
        
        // Output heights above the average
        System.out.println("Heights above the average (" + average + "):");
        for (double height : heights) {
            if (height > average) {
                System.out.println(height);
            }
        }
        
        scanner.close();
    }
}
