public class ReverseString {
    public static void main(String[] args) {
        String input = "desserts";
        System.out.println(reverseString(input));
    }

    public static String reverseString(String string){
        String input = string;
        String newString = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));

            newString += newString + string.charAt(i);
        }

        return newString;
    }
}
