package com.core;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Request {
    

    Method method;
    String path;
    String version;
    HashMap<String, String> headers;
    Logger LOGGER = LoggerFactory.getLogger(Request.class);


   public Request(String requestLine){
        String[] requestLineParts = requestLine.split(" ");
        this.method = Method.valueOf(requestLineParts[0]);
        this.path = requestLineParts[1];
        this.version = requestLineParts[2];
   }

   public void setHeaders(BufferedReader in){

        String headerLine;
        this.headers = new HashMap<>();

        try {
            while(!(headerLine = in.readLine()).isEmpty()){
    
                String[] headerParts = headerLine.split(":", 2);
                if(headerParts.length == 2) this.headers.put(headerParts[0].trim(), headerParts[1].trim());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }

   public HashMap<String, String> getHeaders(){
        return headers;
   }

    public Method getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

}
