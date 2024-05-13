import java.util.Scanner;

public class MethodExample {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        printHello();

        printHello("Mr Sir");

        //you can print it out or store it as another variable
        System.out.println(sum(4 , 5));
        int caculatored = sum(4, 5);
        System.out.println(caculatored);
        

        System.out.println("Enter your greeting name:");
        String personName = myScanner.nextLine();
        System.out.println(creatGreeting(personName));

        myScanner.close();

    }

    public static void printHello(){
        for(int i = 0; i < 5; i++){
        System.out.println("Hello");
        }
    }

    public static void printHello(String name){
        System.out.println("Hello " + name);
    }
    
    public static int sum (int num_1, int num_2){
        int result = num_1 + num_2;

        return result;
    }

    public static String creatGreeting(String name){
        String greeting = "Thanks " + name;
        return greeting;
    }
}
