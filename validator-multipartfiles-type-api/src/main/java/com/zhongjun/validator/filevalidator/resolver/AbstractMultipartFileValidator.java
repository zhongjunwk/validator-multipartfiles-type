package com.zhongjun.validator.filevalidator.resolver;

import cn.hutool.json.JSONObject;
import com.zhongjun.validator.filevalidator.constant.FileType;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * 校验 MultipartFile 的文件类型是否符合要求，抽象类
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 */
public abstract class AbstractMultipartFileValidator {

    /**
     * 校验 MultipartFile 的文件类型是否符合 {@code multipartFileValid} 的要求，只要有一个符合就返回 true
     *
     * @param multipartFileValid 注解
     * @param value              MultipartFile
     * @return true 校验通过, false 校验不通过
     */
    public abstract boolean isFileValid(MultipartFileVerify multipartFileValid, MultipartFile value) throws IOException;

    protected boolean allow(FileType[] fileTypes, String sourceFileType) {
        return Arrays.stream(fileTypes).anyMatch(fileType -> fileType.getName().equalsIgnoreCase(sourceFileType));
    }

    protected boolean isNotAllow(FileType[] fileTypes, String sourceFileType) {
        return !allow(fileTypes, sourceFileType);
    }

    protected String getFileInfo(MultipartFile value) {
        JSONObject fileInfo = new JSONObject();
        fileInfo.set("originalFilename", value.getOriginalFilename());
        fileInfo.set("size", value.getSize());
        return fileInfo.toString();
    }
}
