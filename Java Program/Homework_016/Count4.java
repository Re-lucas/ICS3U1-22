/*
	File Name: Count1.java
	Name: Lucas WU
   	Class: ICS3U1-01
	Date: Mar 28, 2024
	Description: 
*/

import java.util.Scanner;

public class Count4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of 'a': ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of 'b': ");
        int b = scanner.nextInt();

        while (a <= b) {
            System.out.println(a);
            a++;
        }

        scanner.close();
    }
}
