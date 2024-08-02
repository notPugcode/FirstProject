import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class UserList {

    public static void user_list(String usrL, String pswL) throws IOException {

        FileWriter toList = new FileWriter("/Users/sonmigy/GenProjects/FirstProject/TextFiles/UsersPass.txt",true);

        ArrayList<String> TheList = new ArrayList<>();

        TheList.add(usrL);
        TheList.add("-");
        TheList.add(pswL+"\n");

        for(String i: TheList){
            toList.write(i);
        }
        toList.close();
    }
    /*public static String[] getArrayList(ArrayList<String> list) {
        //This method is supposed to return my ArrayList 'TheList' and all its contents
        String[] temp = new String[list.size()];
        return list.toArray(temp);

        //for (int i = 0; i < TheList.size(); i++) {
            //System.out.println(TheList.get(i) + " ");
            //FIGURE THIS OUT!!!!!!!
        //}
    }*/
    
    /*NOTE: This method takes a string parameter and uses an array of type char to break down the string and check each character
            for a number, returning true if so.
     */
    public static boolean hasNum(String hNum) {

        char[] pChar = hNum.toCharArray();

        for (char c : pChar) {
            if(Character.isDigit(c)){
                return true;
            }
        }return false;
    }

    /*NOTE: This method checks if the user and password conditions are met.
            This is done by setting the conditions seen below, simplified from 'if'(all conditons below are met), return true.
            'else', return false.
    */

    public static boolean userCon(String u, String p){

        return !u.isBlank() && u.length() <= 10 && !UserList.hasNum(u) && !p.isBlank() && p.length() <= 12 && UserList.hasNum(p);
    }

    /*NOTE: This method login takes the set parameters as strings, inside the method I use the FileReader class to create my object 
            'readCred' which reads the String variable 'filepath' (given in the parameters) as the File to read. I use the BufferedReader
            class to create my object 'br' which reads the contents of the file that my 'readCred' object has taken.
            The variable 'current' is assigned to 'br.readline' which is basically just assigning the contents of the file to current.
            The String Array 'data' is used to split all the contents in 'current' by the delimiter given in the parameters.
            Now 'data' is set, I use a for loop to go through the array, check if 'user' and 'password' match within, return true if so.
            Try/Catch block is used for any issues with file paths given, this method returns false otherwise. 
    */
    public static boolean login(String user, String password, String filepath, String delimiter){
        String current;
        String[] data;
        try
        {
            FileReader readCred = new FileReader(filepath);
            BufferedReader br = new BufferedReader(readCred);

            while((current = br.readLine()) != null) {
                data = current.split(delimiter);
                for (int i = 0; i < data.length; i++) {
                    if (data[i].equals(user) && data[1].equals(password)) {
                        return true;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}