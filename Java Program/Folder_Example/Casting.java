/**
	File Name: Casting.java
	Name: Ms. Lam
	Class: ICS3U1
	Date: February 28, 2023

	Description: This program demonstrates the types and rules of
   casting.  It also shows the default data types of soeom literal 
   values.
*/

public class Casting {
	public static void main (String[] args) {
		int num = 10;
		byte smallNum = 100;
		long bigNum = 3000000000L;  // requires the 'L' at the end to specify it is a long
		float freal = 2.5f;  // requires the 'f' at the end to specify it is a float, otherwise by default 2.5 is a double
		double real = 2.5;
		
	   smallNum = 65; // this is ok because the compiles can tell 65 can fits in a byte
				
		num = 65;
	   //smallNum = num;   // this will cause an error because the compiler does not know what value num has
		smallNum = (byte)num;  // explicit casting int --> byte
      
		num = 60;
		int realNum = 60;
	   //num = realNum;    
	   // error because realNum is double and can not be auto cast into an int, regardless what value it holds
      num = (int)realNum;    // explicit casting double --> int

		byte smallNum1;
		int num1;
		long bigNum1;
		double real1;
		float freal1;
		
		num1 = 20;
		real1 = num1;  // automatic casting int --> double
		freal1 = num1;	// automatic casting int --> float

		smallNum1 = 50;
		num1 = smallNum1; // automatic casting byte --> int
		bigNum1 = num1; 	// automatic casting int --> long
		
		real1 = bigNum1;	// automatic casting long --> double
		freal1 = bigNum1;	// automatic casting long --> float
		
		char c1 = 'A';
		char c2 = 70;     // automatic casting int (specific value) --> char
		System.out.println(c1);
		System.out.println(c2);	
		
		smallNum1 = (byte)num1; // explicit cast: int --> byte
		num1 = (int)real1;	   // explicit cast: double --> int
		
	}
}