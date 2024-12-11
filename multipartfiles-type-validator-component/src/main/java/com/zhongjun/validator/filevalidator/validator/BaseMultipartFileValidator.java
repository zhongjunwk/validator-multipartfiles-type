package com.zhongjun.validator.filevalidator.validator;

import cn.hutool.core.util.ArrayUtil;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import com.zhongjun.validator.filevalidator.resolver.MultipartFileResolver;
import jakarta.annotation.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 兼容多 MultipartFile 校验
 */
public class BaseMultipartFileValidator {

    @Resource
    private List<MultipartFileResolver> multipartFileResolverList;

    public boolean isValid(MultipartFile[] multipartFiles, MultipartFileVerify multipartFileValid) {
        if (ArrayUtil.isEmpty(multipartFiles)) {
            return true;
        }
        for (MultipartFile multipartFile : multipartFiles) {
            if (!this.isValid(multipartFile, multipartFileValid)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(MultipartFile multipartFile, MultipartFileVerify multipartFileValid) {
        if (multipartFile == null) {
            return true;
        }
        for (MultipartFileResolver multipartFileResolver : multipartFileResolverList) {
            if (!multipartFileResolver.support(multipartFileValid)) {
                continue;
            }
            if (!multipartFileResolver.isFileValid(multipartFileValid, multipartFile)) {
                return false;
            }
        }
        return true;
    }
}