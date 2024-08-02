import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //System.out.println(UserList.getArrayList());
        //System.out.println(UserList.TheList);
        //UserList.getArrayList(UserList.TheList);

        Scanner scanner = new Scanner(System.in);
        File linkFolder = new File("/Users/sonmigy/GenProjects/FirstProject/TextFiles/Links.txt");
        String dLim = "-", existPro = "EXIT";
        boolean createU = true;

        /*NOTE: In the while loop below I use 'if' statements along with methods I have created to;
                -Ask if new or returning user
                -New users create their username and password with set conditions
                    once verified it saves both username and password to the set .txt file, and the loop breaks
                -Returning users use their already created username and password to login
                    once both username and password are found in the .txt file the loop breaks
                -If the wrong input is applied or either of these conditions are not met, then the loop will restart  
        */

        while(createU){
        System.out.println("New users click the -[A] key\nReturning users click the -[B] key");
        String input = scanner.nextLine();
        if(Options.optionA(input)) {
            System.out.println("""
                    Create your username below:
                    [Max 10 Characters & No numbers]""");
            String cUsr = scanner.nextLine();
            System.out.println("Create a password below:\n[Max 12 characters & Must include at least one number]");
            String cPsw = scanner.nextLine();
            if (UserList.userCon(cUsr, cPsw)) {
                System.out.println("Username VALID");
                System.out.println("Password VALID");
                UserList.user_list(cUsr, cPsw);
                System.out.println("Welcome, " + cUsr +"!");
                createU = false;
            }else
                System.out.println("Invalid user or password entered\nPlease try again:");
            }
            else if(Options.optionB(input)) {
            System.out.println("Hello returning user..." +
                    "\nPlease enter your username:");
            String usr = scanner.nextLine();
            System.out.println("Please enter your password:");
            String psw = scanner.nextLine();
            if (UserList.login(usr, psw, "/Users/sonmigy/GenProjects/FirstProject/TextFiles/UsersPass.txt", dLim)) {
                System.out.println("Welcome back, " + usr + "!");
                createU = false;
            } else
                System.out.println("Sorry, those credentials are not in our system!\nPlease try again");
        }
        else
            System.out.println("Error");
        }
    
        System.out.println("Type 'EXIT' at any moment to restart this program");
        boolean keepRunning = true;

        /*NOTE: The following while loops consists of two important parts.
                -First, taking an input and verifying it is a URL, this is done by the method I created in the 'TestURL' class,
                once verified, the object 'buffW' from the BufferedWriter class is used to write the input to 'linkFolder' which
                is an object I created from the File class that holds the filepath I wish to save the links to. The 'append: true'
                is a parameter that is already built into the Class constructor (Which updates the file instead of overwriting it
                everytime). The try and catch block is the safety net in case any errors (assuming something changes with the path)
                -Second, once the link is saved to the file, there is an option to save another link to the file or exit the program,
                I use the options class and its methods I created to validate the input. There is also a 'EXIT' option that can be
                use to exit these loops at any moment. Of course, if any conditons or inputs are not met properly, the loop restarts.
        */

        while(keepRunning) {
            System.out.println("Paste the copy link here: ");
            String vidLink = scanner.nextLine();
            if (TestURL.isValid(vidLink)) {
                System.out.println("Link is valid and will be saved");
                System.out.println(">>>SAVING");
                try {
                    BufferedWriter buffW = new BufferedWriter(new FileWriter(linkFolder, true));
                    buffW.append(vidLink);
                    buffW.newLine();
                    buffW.close();
                    System.out.println("Link to file SAVED");
                    boolean optC = true;
                    while(optC) {
                        System.out.println("If you would like to save another file click the -[A] key" +
                                "\nIf you are done and would like to exit click the -[B] key");
                        String saveMore = scanner.nextLine();
                        if (Options.optionA(saveMore)) {
                            System.out.println("NEW SAVE");
                            optC = false;
                        } else if (Options.optionB(saveMore)) {
                            System.out.println("Link(s) have been saved to file\nLogging out...");
                            keepRunning = false;
                            optC = false;
                        } else if (saveMore.equals(existPro) || saveMore.equals(existPro.toLowerCase())) {
                            System.out.println("Exiting...");
                            System.exit(0);
                        } else
                            System.out.println("Error");
                    }
                }catch(Exception e){
                    System.out.println("ERROR saving link to local file");
                }
            }else if (vidLink.equals(existPro)||vidLink.equals(existPro.toLowerCase())){
                System.out.println("Exiting...");
                System.exit(0);
            }else
                System.out.println("ERROR\nPlease try again");
        }
        scanner.close();
    }
}