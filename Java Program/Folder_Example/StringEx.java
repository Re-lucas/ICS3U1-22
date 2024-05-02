import java.util.Scanner;

class StringEx {
    public static void mian(String[] args){
        Scanner myScanner = new Scanner(System.in);

        int number_1 = 109;
        int number_2 = 109;
        System.out.println(number_1 == number_2);

        String string_1 = "Hello";
        String string_2;
        String string_3;

        System.out.println("string_2: ");
        string_2 = myScanner.nextLine();

        string_3 = string_1;


        //Comparing if the two variables have the same address(references)
        System.out.println("string_1 == String_2: " + (string_1 == string_2));
        System.out.println("string_2 == String_3:" + (string_2 == string_3));

        //Comparomg if the two variables have the same content
        System.out.println("string_1.equals(string_2)" + string_1.equals(string_2));
        System.out.println("string_1.equals(string_3)" + string_1.equals(string_3));
        System.out.println("");

        myScanner.close();
    }
    
}
