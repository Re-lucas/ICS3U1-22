public class CountDays {
    public static int numberOfDays(int month) {
        // Implement logic to return the number of days in the given month
        // (e.g., switch statement or array lookup)
        // ...

        return month;
    }

    public static boolean leapYear(int year) {
        // Implement logic to check if the given year is a leap year
        // (using the conditions mentioned)
        // ...

        return true;
    }

    public static int dayNumber(int year, int month, int day) {
        // Implement logic to calculate the day number
        // (including leap years and invalid parameters)
        // ...

        return year;
    }

    public static void main(String[] args) {
        // Example usage:
        int month = 2; // February
        System.out.println("Days in February: " + numberOfDays(month));

        int testYear = 2024;
        System.out.println("Is " + testYear + " a leap year? " + leapYear(testYear));

        int testDay = 15;
        int testMonth = 5; // May
        int testYear2 = 2023;
        System.out.println("Day number: " + dayNumber(testYear2, testMonth, testDay));
    }
}
