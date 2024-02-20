/*
	File Name: PizzaCost.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Feb 20,2024
	Description: The cost of making a pizza at a local shop is as follows:
    • Labour cost is $0.75 per pizza, regardless of size
    • Rent cost is $1.00 per pizza, regardless of size
    • Materials is $0.05*diameter*diameter (diameter is measured in inches)
    Write a program that prompts that user for the size of a pizza and then display the cost of making the pizza.
*/

import java.util.Scanner;

public class PizzaCost {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        //Variable
        final double labour_cost = 0.75;
        final double rent_cost = 1.00;
        double diameter = 0.00;
        double materials_pizza = 0.05;

        //Equation
        double dia_equation = materials_pizza * diameter * diameter; 
        double total_cost = dia_equation + labour_cost + rent_cost;

        //Asking the user for the diameter for the pizza
        System.out.println("Labour cost is $0.75 per pizza\n" + "Rent cost is $1.00 per pizza\n" + "Materials is $0.05*diameter*diameter");
        System.out.println("Please enter the size (inch) of teh pizza of what you want, and it will display the cost of the pizza: ");
        diameter = myScanner.nextDouble();

        System.out.println("Please type in your materials of your pizza: ");
        materials_pizza = myScanner.nextDouble();

        System.out.println("Here is the total cost of " + diameter + "inch of of pizza: \n" + total_cost );

        myScanner.close();

    }
    
}
