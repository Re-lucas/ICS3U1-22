import java.util.Scanner;

public class ShiftDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[20];
        
  
        for (int i = 0; i < 20; i++) {
            System.out.print("Enter the number of " + (i + 1) + " numbers：");
            array[i] = scanner.nextInt();
        }
        
      
        int lastElement = array[array.length - 1];
        for (int i = array.length - 1; i > 1; i--) {
            array[i] = array[i - 2];
        }
        array[0] = lastElement;
        array[1] = array[array.length - 2];
        
       
        System.out.println("Moved：");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
