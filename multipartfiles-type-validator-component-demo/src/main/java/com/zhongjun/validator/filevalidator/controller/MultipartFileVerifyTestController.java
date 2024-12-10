package com.zhongjun.validator.filevalidator.controller;

import com.zhongjun.validator.filevalidator.annotation.MultipartFileVerify;
import com.zhongjun.validator.filevalidator.constant.FileType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hubin
 * @date 2022/10/14
 */
@Slf4j
@RestController
@RequestMapping(
        value = {"/test"},
        produces = "application/json;charset=UTF-8")
@RequiredArgsConstructor
@Validated
public class MultipartFileVerifyTestController {

    @PostMapping("/testFileUpload")
    public String testFileUpload(@Valid @MultipartFileVerify(value = {FileType.XLS, FileType.XLSX}, message = "请上传XLS、XLSX类型文件") @RequestParam("file") MultipartFile multipartFile) {
        return "true";
    }
}
