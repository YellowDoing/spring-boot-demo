package cn.hg.demo.entity;

import cn.hg.demo.exception.ExceptionEnum;

public class Response<T> {

    private int code;
    private String message;
    private T data;

    public Response() {
        code = 10000;
        message = "操作成功";
    }

    public Response(T t){
        super();
        data = t;
    }

    public Response(ExceptionEnum exceptionEnum) {
        code = exceptionEnum.getCode();
        message = exceptionEnum.getMessage();
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setException(ExceptionEnum exceptionEnum){
        code = exceptionEnum.getCode();
        message = exceptionEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Response<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}