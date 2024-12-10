package com.zhongjun.validator.filevalidator.validator;

import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 兼容多 MultipartFile 校验
 */
@Component
public class MultipartFilesValidator extends AbstractMultipartFileValidator implements ConstraintValidator<MultipartFileVerify, MultipartFile[]> {

    private MultipartFileVerify multipartFileValid;

    @Override
    public void initialize(MultipartFileVerify constraintAnnotation) {
        this.multipartFileValid = constraintAnnotation;
    }

    @Override
    public boolean isValid(MultipartFile[] value, ConstraintValidatorContext context) {
        return super.isValid(value, multipartFileValid);
    }
}