package ui;

import java.util.ArrayList;

public class Helper {
    /*
     * Cast an array list of object into an array list of another type
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
