// The "UseAddOne" class.
public class UseAddOne {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Before Procedure: num = " + num);
        AddOne(num);
        System.out.println("After Procedure: num = " + num);
    } // main method

    public static void AddOne(int a) {
        System.out.println("Begin Procedure: a = " + a);
        a++;
        System.out.println("End Procedure: a = " + a);
    }
} // UseAddOne class

/*
Memory Trace:
num = 10
Before AddOne: num = 10
Inside AddOne: a = 10, after increment: a = 11
After AddOne: num = 10 

*/