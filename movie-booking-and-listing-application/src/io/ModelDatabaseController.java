package io;

import java.util.ArrayList;
import java.util.HashMap;

import model.Model;

/**
 * Main interface to handle database.
 * To use: create a new controller, add and open databases to the controller,
 * use addToDatabase, deleteFromDatabase, getIterator, ... . When finished,
 * use closeAllDatabase to persist the databases.
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

    /**
     * Add a model to the database using the specified model keyword.
     * @param modelKeyword the model keyword
     * @param model the model object
     */
    public void addToDatabase(String modelKeyword, Model model) throws Exception {
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        hm.get(modelKeyword).add(model);
    }

    /**
     * Delete from the database using the specified model keyword and a model.
     * @param modelKeyword the model keyword
     * @param model the model object
     */
    public void deleteFromDatabase(String modelKeyword, Model model) throws Exception{
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }
        hm.get(modelKeyword).remove(model);
    }

    /**
     * Get an arraylist reference to the model. Changing the arraylist will also
     * change the database.
     * @param <M> the model type
     * @param modelKeyword the model keyword
     * @return the arraylist reference
     */
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

    /**
     * Get an arraylist reference to the model. Changing the arraylist will NOT
     * change the database.
     * @param <M> the model type
     * @param modelKeyword the model keyword
     * @return the arraylist reference
     */
    public <M extends Model> ArrayList<M> getEphemeralArrayList(String modelKeyword) throws Exception {
        if (!ModelDatabase.isKeywordValid(modelKeyword)) {
            throw new Exception("Invalid model keyword.");
        }

        return castArrayList(hm.get(modelKeyword));
    }

    /**
     * Cast an arraylist of type s to an arraylist of type t
     * @param <T> target type
     * @param <S> source type
     * @param al target arraylist
     * @return casted arraylist
     */
    @SuppressWarnings("unchecked")
    public static <T,S> ArrayList<T> castArrayList(ArrayList<S> al) {
        ArrayList<T> ret = new ArrayList<>();

        for (S o : al) {
            ret.add((T)o);
        }

        return ret;
    }
}
