package com.zhongjun.validator.filevalidator.resolver;

import cn.hutool.core.io.file.FileNameUtil;
import com.zhongjun.validator.filevalidator.constant.FileType;
import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件类型校验-不允许的文件类型
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 **/
@Slf4j
@NoArgsConstructor
public class MultipartFileNotAllowValidator extends AbstractMultipartFileValidator {

    protected AbstractMultipartFileValidator delegate;

    public MultipartFileNotAllowValidator(AbstractMultipartFileValidator abstractMultipartFileValidator) {
        delegate = abstractMultipartFileValidator;
    }

    @Override
    public boolean isFileValid(MultipartFileVerify multipartFileValid, MultipartFile value) throws IOException {
        FileType[] fileTypes = multipartFileValid.notAllow();
        String sourceFileType = FileNameUtil.extName(value.getOriginalFilename());
        // 不配置 或 没有不允许上传的文件类型，则委托给下一个校验器
        if (ObjectUtils.isEmpty(fileTypes) || isNotAllow(fileTypes, sourceFileType)) {
            return delegate.isFileValid(multipartFileValid, value);
        }
        log.info("不允许上传的文件类型：{}.文件信息：{}", sourceFileType, getFileInfo(value));
        return false;
    }
}
