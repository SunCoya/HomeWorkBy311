package com.example.yunpan.util;

import java.util.UUID;

public class StringTools {
    public static String rename(String fileName){
        String fileRealName=getFileNameNoSuffix(fileName);
        String suffix=getFileNameSuffix(fileName);
        return  fileRealName+"_"+ RandomCode.getRandomCode(5)+suffix;
    }
    public static String getFileNameNoSuffix(String fileName){
        Integer index=fileName.lastIndexOf(".");
        if(index==-1){
            return fileName;
        }
        fileName=fileName.substring(0,index);
        return fileName;
    }
    public static String getFileNameSuffix(String fileName){
        Integer index=fileName.lastIndexOf(".");
        if(index==-1){
            return "";
        }
        fileName=fileName.substring(index);
        return fileName;
    }
}
