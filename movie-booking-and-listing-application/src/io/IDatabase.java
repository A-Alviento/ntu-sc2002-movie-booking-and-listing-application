package io;

/*
 * Interface for database. The data base source can be a text file, binary file
 * or any type of storage hosted on the local machine or remotely. 
 */
public interface IDatabase {
    /*
     * Attempt to open the database.
     */
    public abstract void open() throws DatabaseUnopenableException;


    /*
     * Attempts to close the database.
     */
    public abstract void close() throws DatabaseInUseException;
}