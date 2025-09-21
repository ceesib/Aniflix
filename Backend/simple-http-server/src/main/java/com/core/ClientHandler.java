package com.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClientHandler extends Thread{
    Logger LOGGER = LoggerFactory.getLogger(ClientHandler.class);

    private Socket clientSocket;
    
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        
        try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            String requestLine = in.readLine();


            if(requestLine == null || requestLine.isEmpty()) return; 
            LOGGER.info("The request line is: {}",requestLine);

            Request request = new Request(requestLine);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            request.setHeaders(in);
            Response response = new Response(request);
            response.sendResponse(out);
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                clientSocket.close();
                LOGGER.info("Client connection closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
