/*
	File Name: FastFood.java
	Name: Lucas Wu
	Class: ICS3U1-01
	Date: Feb 20, 2024
	Description: A fast food restaurant charges $1.69 for burgers, $1.09 for fries, and $0.99 for sodas.
	a) Write a program that prompts the employee for the number burgers, fries, and sodas and then displays the totals, the PST (8%), the GST (5%), and the final cost.
	b) Modify the program to prompt the employee for the amount tendered and then display the change due
*/
import java.util.Scanner;

public class FastFood {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Question a)
        final double burgers = 1.69;
        final double fries = 1.09;
        final double sodas = 0.99;

        int num_burgers;
        int num_fries;
        int num_sodas;

        System.out.println("Please enter the number of burgers, fries, and sodas: ");
        System.out.print("burgers: ");
        num_burgers = myScanner.nextInt();
        System.out.print("fries: ");
        num_fries = myScanner.nextInt();
        System.out.print("sodas: ");
        num_sodas = myScanner.nextInt();

        double cost_burgers = num_burgers * burgers;
        double cost_fries = num_fries * fries;
        double cost_sodas = num_sodas * sodas;

        double totalCost = cost_burgers + cost_fries + cost_sodas;
        double pst = totalCost * 0.08; // 8% PST
        double gst = totalCost * 0.05; // 5% GST
        double finalCost = totalCost + pst + gst;

        // Displaying the totals
        System.out.println("Total cost for burgers: $" + cost_burgers);
        System.out.println("Total cost for fries: $" + cost_fries);
        System.out.println("Total cost for sodas: $" + cost_sodas);
        System.out.println("Total cost before taxes: $" + totalCost);
        System.out.println("PST (8%): $" + pst);
        System.out.println("GST (5%): $" + gst);
        System.out.println("Final cost: $" + finalCost);

        // Question b)
        System.out.print("Please enter the amount tendered: $");
        double amountTendered = myScanner.nextDouble();
        double changeDue = amountTendered - finalCost;

        // Displaying the change due
        System.out.println("Change due: $" + changeDue);

        myScanner.close();
    }
}
