/**
	File Name: Tracing.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: February 23, 2023

	Description: This program does random assignments and
   calculation.  It is used to demonstrate how to trace
   a program "by hand"
*/

public class Tracing {
	public static void main (String[] args) {
		int a, b, c;
		double d, e, f;
		
		a = 10;
		b = a / 3;
		c = a + b;
		a = a * a - c;
		
		d = a / b + 1;
		e = a / d;
		f = a * b - d;
		
		System.out.println(a + " " + b + " " + c);
		System.out.println(d + " " + e + " " + f);
	}
}