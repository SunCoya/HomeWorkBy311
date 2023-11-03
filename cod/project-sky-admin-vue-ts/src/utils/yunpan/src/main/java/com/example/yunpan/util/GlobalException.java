package com.example.yunpan.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class GlobalException extends Exception{
    private String message;

    public static GlobalException build(String message){
        return new GlobalException(message);
    }
}
