public class Square {
    public static void square(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    public static void square(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage:
        square(2); // Output: @@
        square(3, '&'); // Output: &&&
                        //         &&&
                        //         &&&
    }
}
