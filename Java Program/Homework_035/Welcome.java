public class Welcome {

    public static void main(String[] args) {
        String name = "Lucas";
        int visitorNum = 1;
        System.out.println(welcomeMessage(name, visitorNum));
    }

    //the question ask for a method to get the variable of a name(String) and number of visitor (int)
    //and return back to a String of serval txt, which mean the method need to be in String type. 
 
    public static String welcomeMessage(String name, int visitorNum) {
        // return "Welcome " + name + "! You are visitor number " + visitorNum + ".";

        String Hello = "Welcome " + name + "! You are visitor number " + visitorNum + ".";

        return Hello;
    }    
}
