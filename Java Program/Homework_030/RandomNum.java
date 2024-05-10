import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {
        Random random = new Random();
        //or it can be int randomNumber = (Math.random() * 100) + 1
        int randomNumber = random.nextInt(101); // Generates a number between 0 and 100
        System.out.println("Random number between 0 and 100: " + randomNumber);
    }
}
