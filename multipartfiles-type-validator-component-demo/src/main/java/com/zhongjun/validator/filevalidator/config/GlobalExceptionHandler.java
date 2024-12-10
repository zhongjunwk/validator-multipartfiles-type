package com.zhongjun.validator.filevalidator.config;

import cn.hutool.json.JSONObject;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleIllegalArgumentException(ConstraintViolationException ex) {
        JSONObject result = new JSONObject();
        result.set("code", HttpStatus.BAD_REQUEST.value());
        result.set("message", "非法参数错误: " + ex.getMessage());
        result.set("data", "");
        result.set("timestamp", LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(result.toString(), headers, HttpStatus.BAD_REQUEST);
    }
}
