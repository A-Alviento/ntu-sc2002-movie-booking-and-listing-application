package io;

import java.io.Serializable;

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
        STORAGE_PATH
    }

    private Type type;
    // A bit unsafe
    private Object value;

    public Config(Type type, Object value) {
        this.type = type;
        this.value = value;
    }


    public Type getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
