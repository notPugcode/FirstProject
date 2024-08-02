//NOTE: This class uses two methods to check if the string in the parameter matches the string given, I use this for input from the user.

public class Options {
    public static boolean optionA (String one){
        String opt = "A";
        return one.equals(opt) || one.equals(opt.toLowerCase());
    }
    public static boolean optionB (String two){
        String opt = "B";
        return two.equals(opt) || two.equals(opt.toLowerCase());
    }
}