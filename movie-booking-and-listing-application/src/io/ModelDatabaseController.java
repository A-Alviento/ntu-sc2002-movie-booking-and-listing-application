package io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import model.*;

public class ModelDatabaseController {
    private HashMap<String, Object> hm;

    public ModelDatabaseController() {
        hm = new HashMap<>();
    }

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

    @SuppressWarnings("unchecked")
    public void closeAllDatabases() throws Exception {
        Iterator<Entry<String, Object>> it = hm.entrySet().iterator();
        while (it.hasNext()) {
            ((ModelDatabase<Model>)it.next().getValue()).close();;
        }
    }

    @SuppressWarnings("unchecked")
    public void addToDatabase(String modelDatabaseKeyword, Model m) throws Exception{
        ((ModelDatabase<Model>)hm.get(modelDatabaseKeyword)).add(m);
    }

    @SuppressWarnings("unchecked")
    public void deleteFromDatabase(String modelDatabaseKeyword, Model m) throws Exception {
        ((ModelDatabase<Model>)hm.get(modelDatabaseKeyword)).remove(m);
    }

    @SuppressWarnings("unchecked")
    public <M extends Model> Iterator<M> getIterator(String modelDatabaseKeyword) throws Exception{
       return ((ModelDatabase<M>)hm.get(modelDatabaseKeyword)).iterator();
    }
}
