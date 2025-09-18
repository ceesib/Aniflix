package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer 
{
    public static void main( String[] args )
    {
        int port = 8080;

        try(ServerSocket serverSocket = new ServerSocket(port)){

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
