package com.core;

public enum Method{
    GET,PUT,POST,DELETE;
    public static int maxLength = -1;
    static {
        for(Method m: values()){
            maxLength = Math.max(maxLength, m.name().length());
        }
    }
    
    
}