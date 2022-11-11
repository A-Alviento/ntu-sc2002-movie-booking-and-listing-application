package io;

import java.util.ArrayList;
import java.util.HashMap;

import model.*;


/**
 * Main interface to handle database.
 * To use: create a new controller, add and open databases to the controller,
 * use addToDatabase, deleteFromDatabase, getIterator, ... . When finished,
 * use closeAllDatabase to persist the databases.
 * 
 * @author Min Khant
 */
public class ModelDatabaseController {
    private ModelDatabase database;
    private HashMap<String, ArrayList<Model>> hm = null;

    /**
     * Create a new model database controller. This, by itself, doesn't do
     * anything.
     * @param   filePath    The path of the database
     */
    public ModelDatabaseController(String filePath) {
        database = new ModelDatabase(filePath);
    }

    /**
     * Open the model database.
     */
    public void openModelDatabase() throws Exception{
        database.open();
        hm = database.arraylist().get(0);
    }

    /**
     * Close the database, which will persist changes to the database.
     */
    public void closeModelDatabase() throws Exception {
        database.close();
        hm = null;
    }

    public void addToDatabase(String modelKeyword, Model m) throws Exception {
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        hm.get(modelKeyword).add(m);
    }

    public void deleteFromDatabase(String modelKeyword, Model m) throws Exception{
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        hm.get(modelKeyword).remove(m);
    }

    public ArrayList<Model> getArrayList(String modelKeyword) throws Exception{
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        return (ArrayList<Model>) hm.get(modelKeyword);
    }
}
