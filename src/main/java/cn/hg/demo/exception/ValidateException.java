package cn.hg.demo.exception;

import org.springframework.validation.ObjectError;

public class ValidateException extends Exception {

    public ValidateException(ObjectError error) {
        super(error.getDefaultMessage());
    }
}
