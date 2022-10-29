import io.*;
import model.*;
import ui.*;

/*
 * Main entry point into the program.
*/
public class Main {
    private static final String configPath = "../config.txt";

    public static void main(String args[]) {
        try {
            ConfigDatabase configDatabase = new ConfigDatabase(configPath, 
                                                new ConfigSerializer());
            configDatabase.open();

 
            configDatabase.close();
        } catch (Exception except) {
            System.out.println(except.getMessage());
        }
    }
}
