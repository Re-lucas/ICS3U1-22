
public class Question_2 {
    /* 

    ### Method Header and Declarations

    ```java
    public int atom(char ch, int x);

    // Variable Declarations
    char m = 'g';
    int b = 10;
    char chr = 'b';
    int num = 89;
    int babble;
    ```

    ### Method Calls

    a) `System.out.println(atom(m, b));`

    - `m` is of type `char` and `b` is of type `int`.
    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - **Valid** call.

    b) `System.out.println(atom(m, babble));`

    - `m` is of type `char` and `babble` is of type `int` but is not value.
    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - **InValid** call (assuming `babble` has been initialized).

    c) `atom(5, 'z');`

    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - `5` is of type `int` and `'z'` is of type `char`, these two can be auto casting.
    - **valid** call.

    d) `if (atom(chr, num) == 9)`

    - `chr` is of type `char` and `num` is of type `int`.
    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - **Valid** call.

    e) `System.out.println(atom("yabba"));`

    - `"yabba"` is a `String`.
    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - **Invalid** call.

    f) `int a = atom('b');`

    - The method header `public int atom(char ch, int x)` expects a `char` and an `int`.
    - This call only provides a `char` and is missing the second `int` argument.
    - **Invalid** call.

    ### Summary of Validity

    - a) **Valid**
    - b) **InValid** (assuming `babble` is initialized)
    - c) **valid**
    - d) **Valid**
    - e) **Invalid**
    - f) **Invalid**

    */
    
}
