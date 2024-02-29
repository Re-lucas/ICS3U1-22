/*
	File Name: OutputPrintf3.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:  List the output of the following code. Use ^ to represent a single space
    a) System.out.printf("%d%n", 500000);
    b) System.out.printf("%+d%n", 500000);
    c) System.out.printf("%+,d%n", 500000);
    d) System.out.printf("%+,10d%n", 500000);
    e) System.out.printf("%+,010d%n", 500000);
    f) System.out.printf("%-+,10d%n", 500000);
    g) System.out.printf("I love %-5s%5s%n", "ics", "3u1");
    h) System.out.printf("I love %5S%-5S%n", "ics", "3u1");
    i) System.out.printf("The average of this class is %6.2f%n", 
    67.8);
    j) System.out.printf("The subtotal is %-5.2f and the total 
    price is %5.2f%n", 2.30, 3.99 );
*/

public class OutputPrintf3 {
    /* 
    a) System.out.printf("%d%n", 500000);

    Output: 500000
    b) System.out.printf("%+d%n", 500000);

    Output: +500000
    c) System.out.printf("%+,d%n", 500000);

    Output: 500,000
    d) System.out.printf("%+,10d%n", 500000);

    Output: 500,000
    e) System.out.printf("%+,010d%n", 500000);

    Output: 000500,000
    f) System.out.printf("%-+,10d%n", 500000);

    Output: 500,000    (with spaces at the end)
    g) System.out.printf("I love %-5s%5s%n", "ics", "3u1");

    Output: I love ics  3u1
    h) System.out.printf("I love %5S%-5S%n", "ics", "3u1");

    Output: I love   ICS3U1
    i) System.out.printf("The average of this class is %6.2f%n", 67.8);

    Output: The average of this class is  67.80
    j) System.out.printf("The subtotal is %-5.2f and the total price is %5.2f%n", 2.30, 3.99);

    Output: The subtotal is 2.30  and the total price is 3.99
    */
}
