package io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * For object(byte) based database files on local storage.
 */
public class ObjectLocalDatabase<T, S extends Serializable> extends LocalDatabase<T, S> {

    
    public ObjectLocalDatabase(String filePath) {
        super(filePath, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void open() throws Exception {
        if (isOpened) return;
        try {
            ObjectInputStream ois = new ObjectInputStream(
                                        new FileInputStream(filePath));

            try {
                while (true) {
                   add((S)ois.readObject());    // compiler will print warnings for this
                }
            } catch (EOFException except) {
                // Do nothing
            }
            ois.close();
            isOpened = true;
        } catch (Exception except) {
            throw except;
        }
        
    }

    @Override
    public void close() throws Exception {
        if (!isOpened) return;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                                    new FileOutputStream(filePath) 
            );
            for (int i=0; i < database.size(); i++) {
                oos.writeObject(database.get(i));
            }
            database = null;
            oos.close();
            isOpened = false;
        } catch (Exception except) {
            throw except;
        }
    }
}
