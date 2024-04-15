import java.util.Scanner;

public class PythagoreanTriples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int maxNumber = scanner.nextInt();
        
        System.out.println("Pythagorean triples with c <= " + maxNumber + ":");
        
        // Find and print all Pythagorean triples
        for (int a = 1; a <= maxNumber; a++) {
            for (int b = a + 1; b <= maxNumber; b++) {
                for (int c = b + 1; c <= maxNumber; c++) {
                    if (a * a + b * b == c * c) {
                        System.out.println(a + ", " + b + ", " + c);
                    }
                }
            }
        }
        
        scanner.close();
    }
}
