/*
	File Name: Variable_002.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 15,2024
	Description: Use BEDMAS to calculate the result of the following equations.
*/

public class Variable_002 {
    public static void main(String[] args) {

        // a) 240 / 8
        System.out.println("The result of 240 / 8 = " + 240 / 8);

        // b) 19 / 3
        System.out.println("The result of 19 / 3 = " + (double) 19 / 3);

        // c) 188 % 9 indicate the reminder
        System.out.println("The result of 188 % 9 = " + 188 % 9);

        // d) 9 % 9
        System.out.println("The result of 9 % 9 = " + 9 % 9);

        // e) 5 + 8.0 / 3.0 
        System.out.println("The result of 5 + 8.0 / 3.0 = " + (double)5 + 8.0 / 3.0);
            
        // f) 3 + (4 * (2 + 2)) % 6
        System.out.println("The result of 3 + (4 * (2 + 2)) % 6 is = " + (double)3 + (4 * (2 + 2)) % 6);

        // g) 4 - 5 * 2 % 4 / 1
        double g_equation = 4 - 5 * 2 % 4 / 1;
        System.out.println("The result of 4 - 5 * 2 % 4 / 1 is =" + g_equation);

        // h) 4 / –9
        System.out.println("The result of 4 / -9 is =" + (double)4 / -9);

        //i) 3 % 4
        System.out.println("The result of 3 % 4 is = " + 3 % 4 );

    }
}

