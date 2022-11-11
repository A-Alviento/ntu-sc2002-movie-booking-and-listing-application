import java.io.File;

import io.*;
import ui.*;

/*
* Main entry point into the program.
*/
public class Main {
    // Temporary workaround for different project path, if one doesn't work
    // try the other
    private static String MODELDATABASEPATH = "data/modeldatabase.ser";
    //private static String MODELDATABASEPATH = "movie-booking-and-listing-application/data/modeldatabase.ser";

    private ModelDatabaseController mdc = null;
    private AppEntry ae= null;

    Main() {
        try {
            File currentDirFile = new File(".");
            String helper = currentDirFile.getAbsolutePath();
            System.out.println(helper);
            this.initializeMain();

            // TODO
            ae.start();

            this.finalizeMain();
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private void initializeMain() throws Exception{
        mdc = new ModelDatabaseController(MODELDATABASEPATH);
        mdc.openModelDatabase();
        ae = new AppEntry(mdc);
    }

    private void finalizeMain() throws Exception {
        ae = null;

        mdc.closeModelDatabase();
        mdc = null;
    }

    public static void main(String args[]) {
        new Main();
    }
}
