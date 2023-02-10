package com.example.xiaoheihe.resultEntity;

import com.example.xiaoheihe.constants.HttpConstant;
import com.example.xiaoheihe.enums.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class Result extends HashMap<String, Object> {
    private int code;
    private String message;
    private Object data;

    public Result() {

    }

    public Result(int code, String message) {
        super.put(HttpConstant.HTTPCODE,code);
        super.put(HttpConstant.HTTPMESSAGE,message);
    }

    public Result(int code, String msg, Object data) {
        super.put(HttpConstant.HTTPCODE, code);
        super.put(HttpConstant.HTTPMESSAGE, msg);
        if (!StringUtils.isEmpty(data)) {
            super.put(HttpConstant.HTTPDATA, data);
        }
    }

    public static Result success(){
        return Result.success("操作成功");
    }

    public static Result success(String message){
        return Result.success(message,null);
    }

    public static Result success(Object data){
        return Result.success("操作成功",data);
    }

    public static Result success(String message,Object data){
        return Result.success(HttpStatus.ok.getCode(),message,data);
    }

    public static Result success(int code,String message,Object data){
        return new Result(code,message,data);
    }


    public static Result error(String message){
        return Result.error(message,null);
    }

    public static Result error(String message, Object data){
        return new Result(HttpStatus.error.getCode(),message,data);
    }

    public static Result error(){
        return Result.error("操作失败");
    }
}
