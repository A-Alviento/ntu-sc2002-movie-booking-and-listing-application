import java.util.Iterator;

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

    Main() {
        try {
            this.initializeMain();

            // TODO

            this.finalizeMain();
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private void initializeMain() throws Exception{
        configDatabase = new ConfigDatabase(configPath, new ConfigSerializer());
        configDatabase.open();
        mdc = new ModelDatabaseController();

        String path, keyword;
        // Add all relevant databases to the controller from the config
        for (Iterator<Config> iter = configDatabase.iterator(); iter.hasNext(); ) {
            Config conf = iter.next();
            if (conf.getType() == Config.Type.DATABASE_PATH) {
                path = (String) conf.getValue().get(0);
                keyword = (String) conf.getValue().get(1);
                mdc.addAndOpenDatabase(path, keyword);
            }
        }
    }

    private void finalizeMain() throws Exception {
        mdc.closeAllDatabases();
        if (configDatabase != null) {
            configDatabase.close();
        }
    }

    public static void main(String args[]) {
        new Main();
    }
}
