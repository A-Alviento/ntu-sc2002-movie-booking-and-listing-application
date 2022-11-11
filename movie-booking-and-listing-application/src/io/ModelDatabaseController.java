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

    @SuppressWarnings("unchecked")
    public <M extends Model> ArrayList<M> getArrayList(String modelKeyword) throws Exception{
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        
        // Workaround for linking database with arraylist
        // Only works for one concurrent database
        ArrayList<M> al = new ArrayList<>();
        for (Model m : hm.get(modelKeyword)) {
            al.add((M)m);
        }

        hm.put(modelKeyword, (ArrayList<Model>) al);

        return al;
    }

    public <M extends Model> ArrayList<M> getEphemeralArrayList(String modelKeyword) throws Exception {
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }

        return castArrayList(hm.get(modelKeyword));
    }

    @SuppressWarnings("unchecked")
    public static <T,S> ArrayList<T> castArrayList(ArrayList<S> al) {
        ArrayList<T> ret = new ArrayList<>();

        for (S o : al) {
            ret.add((T)o);
        }

        return ret;
    }
}
