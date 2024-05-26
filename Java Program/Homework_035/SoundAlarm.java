public class SoundAlarm {
    public static void main(String[] args) {
        // Example usage: Print "Alarm!" 5 times
        alarm(5);
    }

    public static void alarm(int noOfTimes) {

        //So the question is to determine if the number of Times is equal to 1 or not
        //if equal or grater than just for i loop., if not return error
        if (noOfTimes < 1) {
            System.out.println("Error: Parameter must be greater than or equal to 1.");
        } else {
            for (int i = 0; i < noOfTimes; i++) {
                System.out.println("Alarm!");
            }
        }
    }
}
