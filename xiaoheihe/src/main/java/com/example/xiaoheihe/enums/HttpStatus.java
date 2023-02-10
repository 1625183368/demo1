package com.example.xiaoheihe.enums;


public enum HttpStatus {
    ok(200,"成功"),
    error(500,"失败");

    Integer code;
    String message;

    HttpStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
