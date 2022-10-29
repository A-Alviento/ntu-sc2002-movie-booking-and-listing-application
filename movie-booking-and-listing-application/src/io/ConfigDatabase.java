package io;

public class ConfigDatabase extends TextDatabase<Config>{

    public ConfigDatabase(String textFilePath, ISerializer<String, Config> serializer) {
        super(textFilePath, serializer);
    }
    
}
