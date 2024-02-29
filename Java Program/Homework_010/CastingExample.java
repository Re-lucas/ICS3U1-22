/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:
*/
public class CastingExample {
    public static void main(String[] args) {
        int i1 = 5; // ok; default type for non-decimal is int
        // int i2 = 5.2; // error because double cannot be implicitly converted to int

        float f1 = 2; // ok; implicit conversion from int to float
        float f2 = 3.0f; // ok; f signifies to interpret as float
        // float f2 = 3.0; // error because double cannot be implicitly converted to float
        // float f3 = 3.5; // error because double cannot be implicitly converted to float

        double d1 = 3.5; // ok; default type for decimal is double
        double d2 = 2.0; // ok
        double d3 = 4; // ok
        double d4 = 3.5d; // ok; d signifies to interpret as double

        i1 = (int) d1; // explicit casting of a double into an int
        System.out.println("i = " + i1); // prints i = 3

        // i1 = 5.0 / 9.0; // error because double cannot be automatically converted to int
        i1 = 5 / 9; // division of integers yields integer
        System.out.println("i = " + i1); // prints i = 0

        f1 = (float) d1;
        System.out.println("f = " + f1);

        f1 = 5 / 9; 
        System.out.println("f = " + f1); // prints f = 0.0 (integer division)

        // f1 = 5.0/9.0; // error because double cannot be automatically converted to float
        f1 = 5.0f / 9.0f;
        System.out.println("f = " + f1);

        d1 = 3.5 / 2.6;
        System.out.println("d = " + d1);

        d1 = (int) 3.5 / 2.6;
        System.out.println("d = " + d1);

        d1 = (int) (3.5) / 2.6;
        System.out.println("d = " + d1);

        d1 = (int) (3.5 / 2.6);
        System.out.println("d = " + d1);

        // d1 = int 3.5 / 2.6; // error because 'int' cannot be used before a value
        d1 = (int) (3.5 / 2.6);
        System.out.println("d = " + d1);

        d1 = 3.5 / (int) 2.6;
        System.out.println("d = " + d1);

        d1 = (float) (int) (3.5 / 2.6);
        System.out.println("d = " + d1);

        short smallValue = 45;
        // short s = 3.5; // error because double cannot be implicitly converted to short
        // smallValue = 234251434324324; // error because the value is too large for short
        int littleValue = smallValue;
        smallValue = (short) littleValue;
        System.out.println("smallValue = " + smallValue);

        smallValue = (short) 234251434; // Overflow occurs, but no error is reported
        System.out.println("smallValue = " + smallValue);

        // int over = 1111111111111; // error because the value is too large for int

        float pay = 42234.45f;
        long bigValue = 45243224L;
        double amount = 345.45d;
    }
}
