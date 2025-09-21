package com.core;

import java.io.IOException;
import java.net.*;
import org.slf4j.*;

import com.sun.net.httpserver.HttpServer;


public class HttpServerThread extends Thread{
    Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);
    private int port;
    public HttpServerThread(int port){
        this.port = port;
    }
    @Override
    public void run(){
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            LOGGER.info("Server started. Listening on port: {}",this.port);

            while(true){
                Socket clientSocket = serverSocket.accept();
                LOGGER.info("New client connected: {} ", clientSocket.getInetAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
            
        } catch (IOException e) {
              e.printStackTrace();
        }

    }
    
}