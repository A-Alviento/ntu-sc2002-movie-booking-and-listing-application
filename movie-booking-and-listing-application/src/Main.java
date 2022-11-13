import io.*;
import ui.*;

/**
* Main entry point into the program.
*/
public class Main {
    // EDIT THIS IF YOU RECEIVE A FILE NOT FOUND ERROR
    protected static String MODELDATABASEPATH = "data/modeldatabase.ser";

    protected ModelDatabaseController mdc = null;
    protected AppEntry ae= null;

    Main() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("^^^USE THIS TO EDIT MODELDATABASEPATH IN Main.java IF YOU RECEIVE FILENOTFOUND EXCEPTION.");
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
