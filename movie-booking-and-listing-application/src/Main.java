import java.util.Iterator;

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
            ConfigDatabase configDatabase = null;
            ModelDatabaseController mdc = new ModelDatabaseController();


            configDatabase = new ConfigDatabase(configPath, new ConfigSerializer());
            configDatabase.open();

            String path, keyword;

            for (Iterator<Config> iter = configDatabase.iterator(); iter.hasNext(); ) {
                Config conf = iter.next();
                if (conf.getType() == Config.Type.DATABASE_PATH) {
                    path = (String) conf.getValue().get(0);
                    keyword = (String) conf.getValue().get(1);
                    mdc.addAndOpenDatabase(path, keyword);
                }
            }

            mdc.closeAllDatabases();
            if (configDatabase != null) {
                configDatabase.close();
            }
        } catch (Exception except) {
            except.printStackTrace();
        }
    }
}
