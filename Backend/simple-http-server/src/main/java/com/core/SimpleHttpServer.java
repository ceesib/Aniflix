package com.core;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleHttpServer 
{
    public static void main( String[] args ) throws IOException{

        Logger LOGGER = LoggerFactory.getLogger(SimpleHttpServer.class);
        var cm = new ConfigurationManager("Backend/simple-http-server/src/main/java/com/core/config.json");
        var node = cm.readFile();
        var port =  node.get("port").asInt();
        var httpServerThread = new HttpServerThread(port);
        httpServerThread.start();
        
  
    }
}
