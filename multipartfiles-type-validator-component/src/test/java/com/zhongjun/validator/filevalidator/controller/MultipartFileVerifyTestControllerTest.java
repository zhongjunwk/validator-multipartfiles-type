package com.zhongjun.validator.filevalidator.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MultipartFileVerifyTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFileUpload() throws Exception {
        // 创建模拟文件
        MockMultipartFile mockFile = new MockMultipartFile("file",               // 表单字段名
                "example.txt",        // 文件名
                "text/plain",         // 文件类型
                "Hello, Spring Boot!".getBytes() // 文件内容
        );

        // 模拟发送文件上传请求
        mockMvc.perform(MockMvcRequestBuilders.multipart("/testFileUpload").file(mockFile)) // 添加文件
                .andExpect(MockMvcResultMatchers.status().isOk()) // 验证响应状态
                .andExpect(MockMvcResultMatchers.content().string("File uploaded successfully: example.txt")); // 验证响应内容
    }
}