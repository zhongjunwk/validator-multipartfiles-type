package com.zhongjun.validator.filevalidator.resolver;

import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件类型校验-文件大小限制
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 **/
@Slf4j
@NoArgsConstructor
@Component
public class MultipartFileMaxSizeResolver implements MultipartFileResolver {

    @Override
    public boolean isFileValid(MultipartFileVerify multipartFileValid, MultipartFile value) {
        if (value.isEmpty()) {
            return true;
        }
        // 如果没有超过限制，则校验通过；千字节转字节 * 1024
        if (value.getSize() <= multipartFileValid.maxSize() * 1024L) {
            log.info("文件大小超过限制：{}.文件信息：{}", multipartFileValid.maxSize(), this.getFileInfo(value));
            return false;
        }
        return true;
    }

    @Override
    public boolean support(MultipartFileVerify multipartFileValid) {
        // 如果没有配置文件大小限制，则不校验
        return null != multipartFileValid && multipartFileValid.maxSize() > 0;
    }
}
