//import java.net.URL;
//URL myUrl = myUri.toURL();
import java.net.URI;

//NOTE: This is a class that uses a boolean method to check if a string is a URL, this needs a Try/Catch for exceptions.

public class TestURL {
    public static boolean isValid(String url) {
        try {
            URI myUri = new URI(url);
            myUri.toURL();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}