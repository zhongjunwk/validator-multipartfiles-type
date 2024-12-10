package com.zhongjun.validator.filevalidator.resolver;

import cn.hutool.core.io.file.FileNameUtil;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件类型校验-允许的文件类型
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 **/
@Slf4j
@NoArgsConstructor
@Component
public class MultipartFileAllowResolver implements MultipartFileResolver {

    @Override
    public boolean isFileValid(MultipartFileVerify multipartFileValid, MultipartFile value) {
        String sourceFileType = FileNameUtil.extName(value.getOriginalFilename());
        if (this.allow(multipartFileValid.value(), sourceFileType)) {
            return true;
        }
        log.info("允许上传的文件类型：{}.文件信息：{}", sourceFileType, this.getFileInfo(value));
        return false;
    }

    @Override
    public boolean support(MultipartFileVerify multipartFileValid) {
        return null != multipartFileValid && !ObjectUtils.isEmpty(multipartFileValid.value());
    }
}
