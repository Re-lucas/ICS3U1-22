public class Square {
    
    // Method to print n x n square of '@' characters
    public static void square(int n) {
        square(n, '@');
    }

    // Overloaded method to print n x n square of specified character
    public static void square(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Square of size 2 with '@':");
        square(2); // Output: @@ \n @@
        
        System.out.println("Square of size 3 with '&':");
        square(3, '&'); // Output: &&& \n &&& \n &&&
    }
}
