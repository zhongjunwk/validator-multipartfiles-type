package com.zhongjun.validator.filevalidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
@Slf4j
public class FileValidatorDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileValidatorDemoApplication.class, args);
    }

}