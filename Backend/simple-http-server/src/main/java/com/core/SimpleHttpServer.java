package com.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.fasterxml.jackson.databind.*;

public class SimpleHttpServer 
{
    public static void main( String[] args ){

        
        try{
            
            ConfigurationManager cm = new ConfigurationManager("Backend/simple-http-server/src/main/java/com/core/config.json");
            JsonNode node = cm.readFile();
            int port =  node.get("port").asInt();
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port: " + port);

            while(true){

                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
                
            }
        }catch(IOException e){
            
            e.printStackTrace();
        }
    }
}
