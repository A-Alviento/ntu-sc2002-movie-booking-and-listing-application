package io;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Configuration for the application that users can change. This needs to persist
 * throughout different sessions.
 */
public class Config implements Serializable{
    /*
     * Currently, storage path config type is used. Perhaps, other non-essential
     * configurations can be implemented in the future.
     */
    public static enum Type {
        DATABASE_PATH("databasepath");          // format is "databasepath path databasekeyword"
        
        private String name;

        Type(String name) {this.name = name;};

        @Override
        public String toString() {
            return name;
        }
    }

    private Type type;
    // A bit unsafe
    private ArrayList<Object> value;

    public Config(Type type, ArrayList<Object> value) {
        this.type = type;
        this.value = value;
    }


    public Type getType() {
        return this.type;
    }

    public ArrayList<Object> getValue() {
        return this.value;
    }
}
