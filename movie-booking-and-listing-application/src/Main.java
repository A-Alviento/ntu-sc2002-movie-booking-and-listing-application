import io.*;
import model.*;
import ui.*;

/*
* Main entry point into the program.
*/
public class Main {
    private static final String configPath = "../config.txt";
    private ConfigDatabase configDatabase = null;
    private ModelDatabaseController mdc = null;
    private AppEntry ae= null;

    Main() {
        try {
            this.initializeMain();

            // TODO
            ae.start();

            this.finalizeMain();
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private void initializeMain() throws Exception{
        configDatabase = new ConfigDatabase(configPath, new ConfigSerializer());
        configDatabase.open();

        String path, keyword;
        // Initialize setting using configDatabase
        for (Config conf : configDatabase.arraylist()) {
            if (conf.getType() == Config.Type.DATABASE_PATH) {
                path = (String) conf.getValue().get(0);
                keyword = (String) conf.getValue().get(1);
                if (keyword.compareTo("modeldatabase") == 0) {
                    mdc = new ModelDatabaseController(path);
                    mdc.openModelDatabase();
                }
            }
        }
        
        ae = new AppEntry(mdc);
    }

    private void finalizeMain() throws Exception {
        ae = null;

        mdc.closeModelDatabase();
        mdc = null;
        if (configDatabase != null) {
            configDatabase.close();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
