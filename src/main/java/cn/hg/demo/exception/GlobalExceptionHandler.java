package cn.hg.demo.exception;

import cn.hg.demo.entity.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     *参数校验异常
     */
    @ExceptionHandler(ValidateException.class)
    public Response handleValidateError(ValidateException ex) {
        return new Response(ExceptionEnum.EXCEPTION_PARAM_VALIDATE.getCode(),ex.getMessage());
    }

  /*  *//**
     * 无请求体异常
     *//*
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleMissRequestBodyError(HttpMessageNotReadableException ex) {
        return new Response(DemoExceptionEnum.MISSING_REQUEST_BODY_EXCEPTION);
    }

    *//**
     * token验证失效
     *//*
    @ExceptionHandler(TokenException.class)
    public Response handleTokenError(TokenException ex) {
        return new Response(DemoExceptionEnum.TOKEN_VALIDATE__EXCEPTION);
    }

    *//**
     * 数字解析异常
     *//*
    @ExceptionHandler(NumberFormatException.class)
    public Response handleTokenError(NumberFormatException ex) {
        return new Response(DemoExceptionEnum.TNUMBER_FORMAT_EXCEPTION);
    }*/

}
