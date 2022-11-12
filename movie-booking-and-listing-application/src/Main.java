import io.*;
import ui.*;

/**
* Main entry point into the program.
*/
public class Main {
    // Temporary workaround for different project path, if one doesn't work
    // try the other
    // protected static String MODELDATABASEPATH = "data/modeldatabase.ser";
    protected static String MODELDATABASEPATH = "movie-booking-and-listing-application/data/modeldatabase.ser";

    protected ModelDatabaseController mdc = null;
    protected AppEntry ae= null;

    Main() {
        try {
            this.initializeMain();

            this.mainBody();

            this.finalizeMain();
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    protected void initializeMain() throws Exception{
        mdc = new ModelDatabaseController(MODELDATABASEPATH);
        mdc.openModelDatabase();
        ae = new AppEntry(mdc);
    }

    protected void finalizeMain() throws Exception {
        ae = null;
        mdc.closeModelDatabase();
        mdc = null;
    }

    public void mainBody() throws Exception {
        ae.start();
    }

    public static void main(String args[]) {
        new Main();
    }
}
