package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

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
                
                System.out.println("The request line is: " + requestLine);

                Request request = new Request(requestLine);

                /* 
                String[] requestLineParts = requestLine.split(" ");
                String method = requestLineParts[0];
                String path = requestLineParts[1];
                String version = requestLineParts[2];
                */

                


                //System.out.println("method: " + method + " path: " + path + " version: " + version);


                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                //Map<String, String> headers = new HashMap<>();

                request.setHeaders(in);

                /* 
                String headerLine;
                while(!(headerLine = in.readLine()).isEmpty()){
                    //System.out.println(headerLine);
                    String[] headerParts = headerLine.split(":", 2);
                    if(headerParts.length == 2){
                        headers.put(headerParts[0].trim(), headerParts[1].trim());
                    }
                }
                */

                //System.out.println("Headers: " + request.getHeaders());


                if(request.getMethod().equals("GET")){
                    if(request.getPath().equals("/")){
                        sendResponse(out, "200 OK", "text/html", "<h1>Welcome to Aniflix!</h1>");
                    }
                    else{
                        sendResponse(out, "404 Not Found", "text/html", "<h1>404 - Page Not Found</h1>");
                    }
                }else{
                    sendResponse(out, "405 Method Not Allowed", "text/html", "<h1>405 - Method Not Allowed</h1>" );
                }

        


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                clientSocket.close();
                System.out.println("Client connection closed.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void sendResponse(PrintWriter out, String status, String contentType, String body){

        out.println("HTTP/1.1 " + status);
        out.println("Content-Type: " + contentType);
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
    
}
