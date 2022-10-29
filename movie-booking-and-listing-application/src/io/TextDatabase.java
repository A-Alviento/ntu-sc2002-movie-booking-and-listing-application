package io;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.Serializable;

/*
 * The database source is a text file on the local computer. This won't attempt
 * to optimize opening/closing - will read/write everything from/to the source
 * file. Will be inefficient for large source files.
 */
public abstract class TextDatabase<S extends Serializable> implements IDatabase<S>{
    private String textFilePath;
    private boolean isOpened = false;
    private ISerializer<String, S> serializer;
    private ArrayList<S> database;

    public TextDatabase(String textFilePath, ISerializer<String, S> serializer) {
        this.textFilePath = textFilePath;
        this.serializer = serializer;
    }

    /*
     * Read everything from the source file and put into array list.
     */
    @Override
    public void open() throws Exception{
        if (isOpened) {return;}
        try {
            database = new ArrayList<>();
            Scanner sc = new Scanner(new File(textFilePath));
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
            PrintWriter pw = new PrintWriter(textFilePath);
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

    @Override
    public void add(S obj) {
        database.add(obj);
    }
}
