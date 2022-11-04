package io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * The database source is a file on the local computer. This won't attempt
 * to optimize opening/closing - will read/write everything from/to the source
 * file. Will be inefficient for large databases.
 */
public abstract class LocalDatabase<T, S extends Serializable> implements IDatabase<S>{
    protected String filePath;
    protected boolean isOpened = false;
    protected ISerializer<T, S> serializer;
    protected ArrayList<S> database;

    public LocalDatabase(String filePath, ISerializer<T, S> serializer) {
        this.filePath = filePath;
        this.serializer = serializer;
    }

    public void add(S obj) {
        database.add(obj);
    }

    public void remove(S obj) {
        database.remove(obj);
    }

    /*
     * Return the pointer to the database. Keep in mind that this is pass by reference.
     * So if you modify the array or modify the objects in the array, it will also
     * modify the database.
     */
    public Iterator<S> iterator() {
        return database.iterator();
    }

}

