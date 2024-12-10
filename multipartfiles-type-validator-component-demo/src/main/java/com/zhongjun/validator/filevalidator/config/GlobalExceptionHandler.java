package com.zhongjun.validator.filevalidator.config;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleIllegalArgumentException(ConstraintViolationException ex) {
        return new ResponseEntity<>("非法参数错误: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
