package com.core;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleHttpServer 
{
    public static void main( String[] args ) throws StreamReadException, DatabindException, IOException
    {
        //int port = 8080;
        Configuration configuration = new Configuration();

        ObjectMapper mapper = new ObjectMapper();
        configuration = mapper.readValue(new File("Aniflix/Backend/simple-http-server/src/main/util/config.json"), Configuration.class);
            

        try(ServerSocket serverSocket = new ServerSocket(configuration.getPort())){

            System.out.println("Server started. Listening on port: " + configuration.getPort());


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
