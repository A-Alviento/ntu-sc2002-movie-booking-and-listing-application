package io;

import java.util.ArrayList;
import java.util.HashMap;

import model.Model;

/**
 * Database for models.
 */
public class ModelDatabase extends ObjectLocalDatabase<HashMap<String, ArrayList<Model>>> {
    /**
     * List of model keywords. It is expected that you use these to access the
     * database and that the respective model data type is the same.
     */
    public static String[] modelKeywords = {
        "booking", "cinema", "cineplexes", "customeraccount", "movie",
        "movieshowtime", "review", "publicholiday"
    };

    /**
     * Check if a keyword is valid i.e. keyword is in the list of modelKeywords
     * @param   keywords    The target keyword
     */
    public static boolean isKeywordValid(String keyword) {
        for (String s : modelKeywords) {
            if (s.compareTo(keyword) == 0) {
                return true;
            }
        }
        return false;
    }

    public ModelDatabase(String filePath) {
        super(filePath);
    }

    @Override
    public void open() throws Exception {
        super.open();
        if (database.size() == 0) {
            database.add(new HashMap<>());
        }
        HashMap<String, ArrayList<Model>> hm = database.get(0);
        for (String s: modelKeywords) {
            if (!hm.containsKey(s)) {
                hm.put(s, new ArrayList<>());
            }
        }
    }
}
