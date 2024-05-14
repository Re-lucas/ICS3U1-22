public class Square {
    public static void main(String[] args) {
        // Example usage:
        square(2); // Prints @@
        System.out.println(); // New line
        square(3, '&'); // Prints &&&
    }

    public static void square(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("@");
            }
            System.out.println(); // New line
        }
    }

    public static void square(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c);
            }
            System.out.println(); // New line
        }
    }
}
