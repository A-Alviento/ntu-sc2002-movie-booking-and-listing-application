package io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import model.*;


/*
 * Main intrface to handle dataface.
 * To use: create a new controller, add and open databases to the controller,
 * use addToDatabase, deleteFromDatabase, getIterator, ... . When finished,
 * use closeAllDatabase to persist the databases.
 * 
 * @author Min Khant
 */
public class ModelDatabaseController {
    private HashMap<String, Object> hm;

    /*
     * Create a new model database controller. This, by itself, doesn't do
     * anything.
     */
    public ModelDatabaseController() {
        hm = new HashMap<>();
    }

    /*
     * Add a model database to the controller and open it.
     * 
     * @param   path    The path of the database (e.g. "../data/xxx.ser")
     * @param   keyword The keyword relating to the database. This is needed for
     *          future reference to the database by the controller.
     */
    public void addAndOpenDatabase(String path, String keyword) throws Exception{
        switch (keyword) {
            case "customeraccount":
                ModelDatabase<CustomerAccount> customermodel = ModelDatabase.initializeAndOpen(path, keyword);
                hm.put(keyword, customermodel);
                break;
            case "movie":
                ModelDatabase<Movie> moviemodel = ModelDatabase.initializeAndOpen(path, keyword);
                hm.put(keyword, moviemodel);
                break;
            case "review":
                ModelDatabase<Review> reviewmodel = ModelDatabase.initializeAndOpen(path, keyword);
                hm.put(keyword, reviewmodel);
                break;
        }
    }

    /*
     * Close all databases, which will persist all changes to the given filePath.
     */
    @SuppressWarnings("unchecked")
    public void closeAllDatabases() throws Exception {
        Iterator<Entry<String, Object>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            ((ModelDatabase<Model>)it.next().getValue()).close();;
        }
    }

    /*
     * Add a model object to the specified database.
     * 
     * @param   modelDatabaseKeyword    The related keyword for the database
     * @param   m                       The model object 
     */
    @SuppressWarnings("unchecked")
    public void addToDatabase(String modelDatabaseKeyword, Model m) throws Exception{
        ((ModelDatabase<Model>)hm.get(modelDatabaseKeyword)).add(m);
    }

    /*
     * Delete a model object to the specified database.
     * 
     * @param   modelDatabaseKeyword    The related keyword for the database
     * @param   m                       The model object 
     */
    @SuppressWarnings("unchecked")
    public void deleteFromDatabase(String modelDatabaseKeyword, Model m) throws Exception {
        ((ModelDatabase<Model>)hm.get(modelDatabaseKeyword)).remove(m);
    }

    /*
     * Return an iterator for all models in the specified database. Keep in mind
     * that this is pass by reference. If you change the model from the iterator,
     * it will also change the model in the database (and in the file).
     * 
     * @param   modelDatabaseKeyword    The related keyword for the database
     */
    @SuppressWarnings("unchecked")
    public <M extends Model> Iterator<M> getIterator(String modelDatabaseKeyword) throws Exception{
       return ((ModelDatabase<M>)hm.get(modelDatabaseKeyword)).iterator();
    }

    /*
     * Return the shallow array list of all models in the specified database. You
     * can add or remove models from the array list without changing the database,
     * but if you change the model themself, the database will be changed.
     * 
     * @param   modelDatabaseKeyword    The related keyword for the database
     */
    @SuppressWarnings("unchecked")
    public <M extends Model> ArrayList<M> getArrayList(String modelDatabaseKeyword) throws Exception {
        ArrayList<M> shallowArray = new ArrayList<>();
        for (M m : ((ModelDatabase<M>)hm.get(modelDatabaseKeyword)).arraylist()) {
           shallowArray.add(m);
        }
        return shallowArray;
    }
}
