/*
	File Name: Homework_013_04.java
	Name: Lucas Wu
   	Class: ICS3U1-01
	Date: Mar 18,2024
	Description: 
*/

public class Homework_013_04 {
    public static void main(String[] args) {
        int age = 17; // Example age
        int qty_bought = 15; // Example quantity bought
        char gender = 'F'; // Example gender
        double price = 60.0; // Example total price
        double discount = 0.0; // Initializing discount

        // a) If a person’s age lies between 6 and 19, then display “What school do you go to?”
        if (age >= 6 && age <= 19) {
            System.out.println("What school do you go to?");
        }

        // b) If a person is not teenager, then display “You won’t like the music”.
        if (!(age >= 13 && age <= 19)) {
            System.out.println("You won’t like the music");
        }

        // c) If you buy more than 10 items and their total price is at least $50, then the discount is 12% of the total price, otherwise there is no discount.
        if (qty_bought > 10 && price >= 50.0) {
            discount = 0.12 * price;
            System.out.println("Discount applied: $" + discount);
        } else {
            System.out.println("No discount applied");
        }

        // d) If a woman is older than 60 or a man is older than 65, display “RETIRED!”
        if ((gender == 'F' && age > 60) || (gender == 'M' && age > 65)) {
            System.out.println("RETIRED!");
        }
    }
}
