package com.core;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.*;

public class ConfigurationManager{
    /*
     * This class uses Jackson to Deserialize a config.json file
     */
    private File configFile;
    private ObjectMapper objectMapper;
    public ConfigurationManager(String filepath){
        this.configFile = new File(filepath);
        this.objectMapper = new ObjectMapper();
    }
    public JsonNode readFile() throws IOException{
        return this.objectMapper.readTree(this.configFile); 
    }
}