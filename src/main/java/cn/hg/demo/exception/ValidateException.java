package cn.hg.demo.exception;

import org.springframework.validation.Errors;

public class ValidateException extends Exception {

    public ValidateException(Errors errors) {
        super(errors.getAllErrors().size() > 0 ? errors.getAllErrors().get(0).getDefaultMessage():"");
    }
}
