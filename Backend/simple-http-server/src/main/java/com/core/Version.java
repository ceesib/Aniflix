package com.core;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Version {
    HTTP_1_1("HTTP/1.1",1,1);
    public final String LITERAL;
    public final int MAJOR,MINOR;
    static final Pattern httpVersionRegexPattern = Pattern.compile("^HTTP/(?<major>\\d+).(?<minor>\\d+)");
    Version(String LITERAL, int MAJOR, int MINOR) {
        this.LITERAL = LITERAL;
        this.MAJOR = MAJOR;
        this.MINOR = MINOR ;
    }

    public static Version getBestCompatibleVersion(String literalVersion){
        Matcher matcher = httpVersionRegexPattern.matcher(literalVersion);
        //if(!matcher.find()||matcher.groupCount()!=2) throw new HttpParsingException(StatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        int major = Integer.parseInt(matcher.group("major"));
        int minor = Integer.parseInt(matcher.group("minor"));
        Version temp = null;
        for(Version v :Version.values()){
            if(v.LITERAL.equals(literalVersion)) return v;
            else 
                if(v.MAJOR==major && v.MINOR<minor) temp = v;
        }
        return temp;   
    }

    
}
