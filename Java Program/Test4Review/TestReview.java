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

 /*
  Let's perform a memory trace on the execution of the program and determine the output.

```java
public class TestReview {
    public static void alpha(char ch) {
        char beta = (char) (ch + 2);
        System.out.println(beta);
    }

    public static int regulate(int x, int y) {
        int flip = x + y * 5;
        return flip;
    }

    public static void main(String[] args) {
        char cap = 'g';
        int num = 3;
        System.out.println(5 + regulate(5, num));
        alpha(cap);
    }
}
```

### Memory Trace and Output:

1. **Memory Initialization**:
    - `main` method starts execution.
    - `cap` is initialized to `'g'`.
    - `num` is initialized to `3`.

2. **Call to `regulate(5, num)`**:
    - `x = 5`
    - `y = num` which is `3`
    - Inside `regulate` method:
        - `int flip = 5 + 3 * 5`
        - `flip = 5 + 15`
        - `flip = 20`
    - `regulate` returns `20`.

3. **Back to `main` method**:
    - `System.out.println(5 + regulate(5, num))` becomes `System.out.println(5 + 20)`.
    - `5 + 20 = 25`
    - Output: `25`

4. **Call to `alpha(cap)`**:
    - `ch = cap` which is `'g'`
    - Inside `alpha` method:
        - `char beta = (char) ('g' + 2)`
        - `beta = (char) (103 + 2)` (ASCII value of 'g' is 103)
        - `beta = (char) 105`
        - `beta = 'i'`
    - `System.out.println(beta)` prints `'i'`.

5. **Back to `main` method**:
    - `alpha(cap)` has executed and returned.

### Final Output:

- The first output is `25` from the `System.out.println(5 + regulate(5, num))`.
- The second output is `i` from the `System.out.println(beta)` inside the `alpha` method.

### Memory Trace Summary:

- **Variables in `main`**:
    - `cap = 'g'`
    - `num = 3`

- **Variables in `regulate`**:
    - `x = 5`
    - `y = 3`
    - `flip = 20`

- **Variables in `alpha`**:
    - `ch = 'g'`
    - `beta = 'i'`

### Complete Output:

```
25
i
```
  */