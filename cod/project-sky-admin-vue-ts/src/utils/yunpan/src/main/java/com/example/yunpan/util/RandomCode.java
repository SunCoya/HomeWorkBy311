package com.example.yunpan.util;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCode {

    public static String getRandomCode(Integer codeLength){
        return RandomStringUtils.random(codeLength,false,true);
    }
    public static String getRandomString(Integer codeLength){
        return RandomStringUtils.random(codeLength,true,true);
    }
}
