/*
	File Name: OutputPrintf1.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 29, 2024
	Description: Write a program that uses printf (to format the names 
    and the balances) to output the following:
    Juanita's bank account balance is $2,345,678.99.
    Juan's bank account balance is $ 15,455.26.
*/

public class OutputPrintf1 {
    public static void main(String[] args) {
        String juanitaName = "Juanita";
        double juanitaBalance = 2345678.99;

        String juanName = "Juan";
        double juanBalance = 15455.26;

        System.out.printf("%s's bank account balance is $%,.2f.%n", juanitaName, juanitaBalance);
        System.out.printf("%s's bank account balance is $%,.2f.%n", juanName, juanBalance);
    }
}
