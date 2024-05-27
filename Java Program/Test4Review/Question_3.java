public class Question_3 {
        public static void main(String[] args) {
            double celsius = 32.0;
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.println("Temperature in Fahrenheit: " + fahrenheit);

            int start = 10; // start
            int end = 20;   // end
    
            printValues(start, end);
        }
    
        // a)Method to convert Celsius to Fahrenheit:
        public static double celsiusToFahrenheit(double celsius) {
            double fahrenheit = (celsius * 1.8) + 32;
            return fahrenheit;
        }
    

    //b) Method to print values between two integers:
    public static void printValues(int start, int end){
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
    }
    
}
