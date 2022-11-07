package io;

import java.util.ArrayList;
import java.util.HashMap;

import model.Model;

public class ModelDatabase extends ObjectLocalDatabase<HashMap<String, ArrayList<Model>>> {
    public static String[] modelKeywords = {
        "booking", "cinema", "cineplexes", "customeraccount", "movie",
        "movieshowing", "review"
    };

    /*
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

    /*
     * Keyword is used to uniquely identify the model database from other databases.
     * @param   filePath    The path of the database
     */
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
