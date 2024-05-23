// The "UseSwap" class.
public class UseSwap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("Before swap: a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("After swap: a = " + a + " b = " + b);
    } // main method

    public static void swap(int num1, int num2) {
        int temp;
        System.out.println("Beginning of procedure: num1 = " + num1 + " num2 = " + num2);
        temp = num2;
        num2 = num1;
        num1 = temp;
        System.out.println("End of procedure: num1 = " + num1 + " num2 = " + num2);
    }
} // UseSwap class


/*
 Memory Trace:
    a = 10, b = 20
    Before swap: a = 10, b = 20
    Inside swap: num1 = 10, num2 = 20, after swap: num1 = 20, num2 = 10
    After swap: a = 10, b = 20
 
    Before swap: a = 10 b = 20
    Beginning of procedure: num1 = 10 num2 = 20
    End of procedure: num1 = 20 num2 = 10
    After swap: a = 10 b = 20

 */