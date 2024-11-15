package com.zhongjun.validator.filevalidator.validator;

import com.zhongjun.validator.filevalidator.resolver.AbstractMultipartFileValidator;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 单个 MultipartFile 校验
 */
public class MultipartFileValidator implements ConstraintValidator<MultipartFileVerify, MultipartFile> {

    @Autowired
    private AbstractMultipartFileValidator abstractMultipartFileValidator;

    private MultipartFileVerify multipartFileValid;

    @Override
    public void initialize(MultipartFileVerify constraintAnnotation) {
        this.multipartFileValid = constraintAnnotation;
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            return abstractMultipartFileValidator.isFileValid(multipartFileValid, value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}