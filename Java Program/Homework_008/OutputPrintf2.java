/*
	File Name: OutputPrintf2.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description:  OutputPrintf2.java: Write the program that uses prinf to produce the 
    following table. Minimize the number of characters in string literals (in quotes) by 
    using equations.
    Number Square
    1.10 1.21000
    1.11 1.23210
    1.12 1.25440
    1.13 1.27690
    1.14 1.29960
    1.15 1.32250
*/

public class OutputPrintf2 {
    public static void main(String[] args) {
        double baseNumber = 1.10;

        System.out.printf("%-5s %-7s%n", "Number", "Square");
        for (int i = 0; i < 6; i++) {
            double square = baseNumber * baseNumber;
            System.out.printf("%.2f %.5f%n", baseNumber, square);
            baseNumber += 0.01;
        }
    }
}
