package io;

public class ConfigDatabase extends TextLocalDatabase<Config>{

    public ConfigDatabase(String textFilePath, ISerializer<String, Config> serializer) {
        super(textFilePath, serializer);
    }
    
}
