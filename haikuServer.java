import java.net.*;
import java.io.*;
import java.util.*;

public class haikuServer {

    private static String chooseHaiku() {
    	
        String[] haiku = new String[3];
        
        haiku[0] = "Pawprints disappear"+"\n"+"into the snowy glen, but"+"\n"+"fox waits patiently.";
        haiku[1] = "Whispering winds cry"+"\n"+"while frenzied snowflakes scatter,"+"\n"+"searching for others.";
        haiku[2] = "The path, hard and long"+"\n"+"brings dawn with passage of time"+"\n"+"and then my heart sings.";

        Random t = new Random();
        int ch = t.nextInt(3); 
        return haiku[ch];
    }

    public static void main(String[] args) {
    	
        try {
            ServerSocket sock = new ServerSocket(5575);

            while (true) {
                Socket client = sock.accept();

                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                String haiku = chooseHaiku();
                pout.println(haiku);
                client.close();
            }
        } catch (Exception e) {}
    }
}