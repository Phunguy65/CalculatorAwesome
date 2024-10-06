package com.java_awesome.models;

public class MathConverter {
    public static String convertTo(char c) {
        return MathParseTable.DisplayToRaw.get(String.valueOf(c)).toString();
    }
    
    public static String convertBack(char c){
        return MathParseTable.DisplayTable.get((int)c);
    }
    
    public static String convertTo(String s){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(convertTo(s.charAt(i)));
        }
        
        return sb.toString();
    }
    
    
    public static String convertBack(String s){
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(convertBack(s.charAt(i)));
        }
        
        return sb.toString();
    }
}
