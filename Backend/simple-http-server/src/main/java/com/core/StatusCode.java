package com.core;

public enum StatusCode{
    /* --- CLIENT ERRORS (4xx) --- */
    CLIENT_ERROR_400_BAD_REQUEST(400,"Bad Request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(401,"Not allowed"),
    CLIENT_ERROR_414_TOO_LONG(414,"Too Long"),
    CLIENT_ERROR_404_NOT_FOUND(404, "Not Found"),

    /*--- SERVER ERRORS (5xx)--- */
    SERVER_ERROR_500_INTERNAL_SERVER_ERROR(500,"Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED(501,"Not Implemented"),
    SERVER_ERROR_505_VERSION_NOT_SUPPORTED(501,"Version not supported"),

    /* --- CLIENT SUCCESS */ 
    CLIENT_SUCCESS_200_OK(200,"Ok"),
    CLIENT_SUCCESS_201_CREATED(201,"Created"),
    CLIENT_SUCCESS_204_NO_CONTENT(201,"No content");

    public final int STATUS_CODE;
    public final String MESSAGE;
    StatusCode(int STATUS_CODE,String MESSAGE){
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }


}