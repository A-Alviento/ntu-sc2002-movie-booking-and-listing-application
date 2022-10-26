package io;

import java.util.Scanner;
import java.util.ArrayList;
import model.Model;

/*
 * The database source is a text file on the local computer.
 */
public abstract class TextLocalDatabase implements IDatabase{
    private String textFilePath;
    private boolean isOpened = false;
    ArrayList<Model> models;
    ISerializer serializer;
    
    Scanner sc;

    public TextLocalDatabase(String textFilePath) {
        this.textFilePath = textFilePath;
    }
}
