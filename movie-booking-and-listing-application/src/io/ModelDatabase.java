package io;

import java.io.File;
import java.io.FileNotFoundException;

import model.Model;

public class ModelDatabase<M extends Model> extends ObjectLocalDatabase<M> {

    private String keyword;

    /*
     * Keyword is used to uniquely identify the model database from other databases.
     */
    public ModelDatabase(String filePath, String keyword) {
        super(filePath);
    }
   
    public String getKeyword() {
        return keyword;
    }

    /*
     * Initialize a model database and open it. If the database file does not
     * exists, then create it. Then try to open it again.
     * Returns the reference to the database.
     */
    public static <T extends Model> ModelDatabase<T> initializeAndOpen(String path, String keyword) throws Exception{
        ModelDatabase<T> database = new ModelDatabase<>(path, keyword);
        try {
            database.open();
            return database;
        } catch (FileNotFoundException except) {
            File newFile = new File(path);
            newFile.createNewFile();
        } catch (Exception except) {
            throw except;
        }

        // try opening again since we've create the file
        try {
            database.open();
            return database;
        } catch (Exception except) {
            throw except;
        }

    }
}
