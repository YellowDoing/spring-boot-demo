package cn.hg.demo.exception;

import cn.hg.demo.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     *参数校验异常
     */
    @ExceptionHandler(ValidateException.class)
    public Response handleValidateError(ValidateException ex) {
        return new Response(DemoExceptionEnum.VALIDATE_EXCEPTION.setMeaage(ex.getMessage()));
    }

    /**
     * 无请求体异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleMissRequestBodyError(HttpMessageNotReadableException ex) {
        return new Response(DemoExceptionEnum.MISSING_REQUEST_BODY_EXCEPTION);
    }

}
