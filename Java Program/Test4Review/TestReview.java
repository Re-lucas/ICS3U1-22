    //a) Number the code in the order that it is executed.
    public class TestReview {
        // 5. Executes
        public static void alpha(char ch) {
            // 6. Executes
            char beta = (char) (ch + 2);
            // 7. Executes
            System.out.println(beta);
        }
    
        // 3. Executes
        public static int regulate(int x, int y) {
            // 4. Executes
            int flip = x + y * 5;
            return flip; // 5. Returns the value
        }
    
        public static void main(String[] args) {
            // 1. Executes
            char cap = 'g';
            // 2. Executes
            int num = 3;
            // 3. Executes
            System.out.println(5 + regulate(5, num));
            // 6. Executes
            alpha(cap);
        } // main method
    } // TestReview class

    /*
    b) List the formal parameters:
    alpha: char ch
    regulate: int x, int y

    c) How many methods are there?
    There are three methods:

    alpha
    regulate
    main

    d) List those methods that return values:
    regulate (returns an int value)
    main (returns void, which means it doesn't return a value)

    e) What variables are local to the method regulate?
    The local variables in the regulate method are:

    int x
    int y
    int flip
    
    f) Circle the method calls in the above code.
    regulate(5, num)
    alpha(cap)
 */