// The "UseAddOneArray" class.
public class UseAddOneArray {
    public static void main(String[] args) {
        int num[] = {3, 5, 6, 7, 8, 10};
        System.out.println("Before Procedure: ");
        for (int i = 0; i < num.length; i++) {
            System.out.println("num[" + i + "] = " + num[i]);
        }
        AddOneArray(num);
        System.out.println("After Procedure: ");
        for (int i = 0; i < num.length; i++) {
            System.out.println("num[" + i + "] = " + num[i]);
        }
    } // main method

    public static void AddOneArray(int[] a) {
        System.out.println("Begin Procedure: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i]++;
        }
        System.out.println("End Procedure: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
} // UseAddOneArray class
