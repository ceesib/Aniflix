package com.core;

import java.io.PrintWriter;

public class Response {
    private Method method;
    private String path;

    public Response(Request request){
        this.method = request.getMethod();
        this.path = request.getPath();
    }
    public void sendResponse(PrintWriter out){
                if(this.method.equals(Method.GET)){
                    if(this.path.equals("/")) respond(out, StatusCode.CLIENT_SUCCESS_200_OK, "text/html", "<h1>Welcome to Aniflix!</h1>");
                    
                    else respond(out, StatusCode.CLIENT_ERROR_404_NOT_FOUND, "text/html", "<h1>404 - Page Not Found</h1>");   
                }
                else respond(out, StatusCode.CLIENT_ERROR_401_METHOD_NOT_ALLOWED, "text/html", "<h1>405 - Method Not Allowed</h1>" );
    }
    private void respond(PrintWriter out, StatusCode status, String contentType, String body){
        out.println("HTTP/1.1 " + status.STATUS_CODE);
        out.println("Content-Type: " + contentType);
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
}
