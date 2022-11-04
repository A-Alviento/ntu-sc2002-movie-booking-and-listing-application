package io;

import java.util.ArrayList;

public class ConfigSerializer implements ISerializer<String, Config>{

    @Override
    public String serialize(Config obj) throws Exception {
        ArrayList<Object> arr = obj.getValue();
        if (obj.getType() == Config.Type.DATABASE_PATH) {
            return String.format(
                                "%s %s %s",
                                obj.getType().toString(),
                                arr.get(0).toString(),
                                arr.get(1).toString());
        } else {
            throw new Exception("Config has no/invalid type.");
        }
    }

    @Override
    public Config deserialize(String src) throws Exception {
        String[] s = src.split(" ", 0);
        ArrayList<Object> arr = new ArrayList<>();

        if (s.length == 0) {
            throw new Exception("Error in deserializing.");
        }
        
        if (s[0].compareTo("databasepath") == 0) {
            arr.add(s[1]);
            arr.add(s[2]);
            return new Config(Config.Type.DATABASE_PATH, arr);
        } else {
            throw new Exception("Error in deserializing. Invalid config type.");
        }
    }
    
}
