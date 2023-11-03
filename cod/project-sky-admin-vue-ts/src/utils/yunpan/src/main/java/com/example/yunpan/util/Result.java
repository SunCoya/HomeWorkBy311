package com.example.yunpan.util;


import lombok.Data;

/**
 * 全局统一返回结果类
 *
 */
@Data

public class Result<T> {


    private Integer code;


    private String message;


    private T data;

    public Result(){}

    // 返回数据
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> Result<T> build(T body, String message,Integer code) {
        Result<T> result = build(body);
        result.setMessage(message);
        result.setCode(code);
        return result;
    }

    public static<T> Result<T> ok(){
        return Result.ok(null);
    }

    /**
     * 操作成功
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, "成功",200);
    }


    /**
     * 操作失败
     * @param data
     * @param <T>
     * @return
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = build(data);
        return build(data, "失败",201);
    }
}
