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

/*
    Memory Trace:
    num = [3, 5, 6, 7, 8, 10]
    Before AddOneArray: num = [3, 5, 6, 7, 8, 10]
    Inside AddOneArray: a = [3, 5, 6, 7, 8, 10], after increment: a = [4, 6, 7, 8, 9, 11]
    After AddOneArray: num = [4, 6, 7, 8, 9, 11] 

    Before Procedure:
    num[0] = 3
    num[1] = 5
    num[2] = 6
    num[3] = 7
    num[4] = 8
    num[5] = 10
    Begin Procedure:
    a[0] = 3
    a[1] = 5
    a[2] = 6
    a[3] = 7
    a[4] = 8
    a[5] = 10
    End Procedure:
    a[0] = 4
    a[1] = 6
    a[2] = 7
    a[3] = 8
    a[4] = 9
    a[5] = 11
    After Procedure:
    num[0] = 4
    num[1] = 6
    num[2] = 7
    num[3] = 8
    num[4] = 9
    num[5] = 11

*/