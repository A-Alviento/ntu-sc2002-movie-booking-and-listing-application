package io;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * For text based database files on local storage.
 * 
 * @author Min Khant
 */
public abstract class TextLocalDatabase<S extends Serializable> extends LocalDatabase<String, S>{
    public TextLocalDatabase(String filePath, ISerializer<String, S> serializer) {
        super(filePath, serializer);
    }

    /*
     * Read everything from the source file and put into array list.
     */
    @Override
    public void open() throws Exception{
        if (isOpened) {return;}
        try {
            database = new ArrayList<>();
            Scanner sc = new Scanner(new File(filePath));
            while (sc.hasNext()) {
                database.add(serializer.deserialize(sc.nextLine().strip()));
            }
            sc.close();
            isOpened = true;
        } catch (Exception except) {
            throw except;
        }
    }


    /*
     * Write everything from the array list back to the source file.
     */
    @Override
    public void close() throws Exception{
        if (!isOpened) {return;}
        try {
            PrintWriter pw = new PrintWriter(filePath);
            for (int i=0; i < database.size(); i++) {
                pw.println(serializer.serialize(database.get(i)));
            }
            database = null;
            pw.close();
            isOpened = false;
        } catch (Exception except) {
            throw except;
        }
    }

}
