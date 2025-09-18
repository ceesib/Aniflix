package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Request {
    

    String method;
    String path;
    String version;
    HashMap<String, String> headers;

   public Request(String requestLine){
        String[] requestLineParts = requestLine.split(" ");
        this.method = requestLineParts[0];
        this.path = requestLineParts[1];
        this.version = requestLineParts[2];

   }

   public void setHeaders(BufferedReader in){

        String headerLine;
        this.headers = new HashMap<>();

        try {
            while(!(headerLine = in.readLine()).isEmpty()){
                //System.out.println(headerLine);
                String[] headerParts = headerLine.split(":", 2);

                if(headerParts.length == 2){
                    this.headers.put(headerParts[0].trim(), headerParts[1].trim());
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }

   public HashMap<String, String> getHeaders(){

        return headers;
   }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

}
