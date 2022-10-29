package io;

public class ConfigSerializer implements ISerializer<String, Config>{

    @Override
    public String serialize(Config obj) throws Exception {
        if (obj.getType() == Config.Type.STORAGE_PATH) {
            return String.format(
                                "%s,%s",
                                obj.getType().toString(),
                                obj.getValue().toString());
        } else {
            throw new Exception("Config has no/invalid type.");
        }
    }

    @Override
    public Config deserialize(String src) throws Exception {
        String[] s = src.split(",", 0);

        if (s.length == 0) {
            throw new Exception("Error in deserializing.");
        }
        
        if (s[0].compareTo("STORAGE_PATH") == 0) {
            return new Config(Config.Type.STORAGE_PATH, s[1]);
        } else {
            throw new Exception("Error in deserializing. Invalid config type.");
        }
    }
    
}
