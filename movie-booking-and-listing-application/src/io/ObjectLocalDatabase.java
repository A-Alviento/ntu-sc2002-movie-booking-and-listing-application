package io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * For object(byte) based database files on local storage.
 */
public class ObjectLocalDatabase<S extends Serializable> extends LocalDatabase<S, S> {
    /**
     * Use this constructor if you don't want to change the object
     * before serializing.
     * 
     * @param filePath The path of the object database.
     */
    public ObjectLocalDatabase(String filePath) {
        super(filePath, new IdentitySerializer<S>());
    }

    /**
     * Use this constructor if you want to change the object before
     * serializing.
     *
     * @param filePath      The path of the object database.
     * @param serializer    The serializer, which transforms the object to another
     *                      object 
     */
    public ObjectLocalDatabase(String filePath, ISerializer<S, S> serializer) {
        super(filePath, serializer);
    }

    /**
     * Will create a new file if it does not exist.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void open() throws Exception {
        if (isOpened) return;

        File f = new File(filePath);
        if(!f.exists()) { 
            f.createNewFile();
        }

        try {
            database = new ArrayList<>();
            ObjectInputStream ois = new ObjectInputStream(
                                        new FileInputStream(filePath));
            Object o = null;
            while ((o = ois.readObject()) != null) {
                   database.add(serializer.deserialize((S)o));    // compiler will print warnings for this
            }
            ois.close();
            isOpened = true;
        } catch (EOFException except) {
            // do nothing, the object file is empty
            isOpened = true;
        } catch (Exception except) {
            throw except;
        }
        
    }

    /**
     * Write everything from the array list back to the source file.
     */
    @Override
    public void close() throws Exception {
        if (!isOpened) return;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                                    new FileOutputStream(filePath) 
            );
            for (int i=0; i < database.size(); i++) {
                oos.writeObject(serializer.serialize(database.get(i)));
            }
            database = null;
            oos.close();
            isOpened = false;
        } catch (Exception except) {
            throw except;
        }
    }
}

/**
 * Serializer which just returns the object passed to it.
 */
class IdentitySerializer<S extends Serializable> implements ISerializer<S, S> {
    @Override
    public S serialize(S obj) throws Exception {
        return obj;    
    }

    @Override
    public S deserialize(S src) throws Exception {
    return src;
    }
}
