// The "UseSwapArray" class.
public class UseSwapArray {
    public static void main(String[] args) {
        int num[] = {3, 10};
        System.out.println("Before Procedure: num[0] = " + num[0] + " num[1] = " + num[1]);
        SwapUseArray(num);
        System.out.println("After Procedure: num[0] = " + num[0] + " num[1] = " + num[1]);
    } // main method

    public static void SwapUseArray(int[] a) {
        System.out.println("Begin Procedure: a[0] = " + a[0] + " a[1] = " + a[1]);
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
        System.out.println("End Procedure: a[0] = " + a[0] + " a[1] = " + a[1]);
    }
} // UseSwapArray class


/*
    Memory Trace:
    num = [3, 10]
    Before SwapUseArray: num[0] = 3, num[1] = 10
    Inside SwapUseArray: a[0] = 3, a[1] = 10, after swap: a[0] = 10, a[1] = 3
    After SwapUseArray: num[0] = 10, num[1] = 3

    Before Procedure: num[0] = 3 num[1] = 10
    Begin Procedure: a[0] = 3 a[1] = 10
    End Procedure: a[0] = 10 a[1] = 3
    After Procedure: num[0] = 10 num[1] = 3

 */