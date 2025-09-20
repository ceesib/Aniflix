package com.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SimpleHttpServer 
{
    public static void main( String[] args ){

        Logger LOGGER = LoggerFactory.getLogger(SimpleHttpServer.class);

        try{
            
            var cm = new ConfigurationManager("Backend/simple-http-server/src/main/java/com/core/config.json");
            var node = cm.readFile();
            var port =  node.get("port").asInt();
            ServerSocket serverSocket = new ServerSocket(port);
            LOGGER.info("Server started. Listening on port: {}",port);

            while(true){

                Socket clientSocket = serverSocket.accept();
                LOGGER.info("New client connected: {} ", clientSocket.getInetAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
                
            }
        }catch(IOException e){
            
            e.printStackTrace();
        }
    }
}
