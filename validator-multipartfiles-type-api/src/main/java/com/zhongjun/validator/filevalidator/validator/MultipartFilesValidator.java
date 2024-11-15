package com.zhongjun.validator.filevalidator.validator;

import com.zhongjun.validator.filevalidator.resolver.AbstractMultipartFileValidator;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 兼容多 MultipartFile 校验
 */
public class MultipartFilesValidator implements ConstraintValidator<MultipartFileVerify, MultipartFile[]> {

    @Autowired
    private AbstractMultipartFileValidator abstractMultipartFileValidator;

    private MultipartFileVerify multipartFileValid;

    @Override
    public void initialize(MultipartFileVerify constraintAnnotation) {
        this.multipartFileValid = constraintAnnotation;
    }

    @Override
    public boolean isValid(MultipartFile[] value, ConstraintValidatorContext context) {
        if (value == null || value.length == 0) {
            return true;
        }
        for (MultipartFile multipartFile : value) {
            try {
                if (!abstractMultipartFileValidator.isFileValid(multipartFileValid, multipartFile)) {
                    return false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}