package cn.hg.demo.entity;

import cn.hg.demo.exception.DemoExceptionEnum;

public class Response<T> {

    private int code;
    private String message;
    private T data;

    public Response() {
        code = 200;
        message = "操作成功";
    }

    public Response(DemoExceptionEnum exceptionEnum) {
        code = exceptionEnum.getCode();
        message = exceptionEnum.getMeaage();
    }

    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
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
