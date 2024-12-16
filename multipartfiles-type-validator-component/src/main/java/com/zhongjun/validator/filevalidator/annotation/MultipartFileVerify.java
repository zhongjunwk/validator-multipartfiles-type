package com.zhongjun.validator.filevalidator.annotation;


import com.zhongjun.validator.filevalidator.constant.FileType;
import com.zhongjun.validator.filevalidator.validator.MultipartFileValidator;
import com.zhongjun.validator.filevalidator.validator.MultipartFilesValidator;
import jakarta.validation.Constraint;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 功能描述: 附件检验
 * 基于 spring validated 框架的文件上传校验注解；
 * 校验 MultipartFile 的文件类型是否符合要求；
 * 目前场景只在 form 表单中进行文件上传，因此 Target 只使用 PARAMETER；
 * 关于转发时用的 JsonObject 形式，使用的并不是 MultipartFile 类，因此无需标记上 FIELD；
 * fixme 可以考虑后续使用组合注解方式，参照 spring 的 @RestController 注解，但是组合注解并非 Java 原生支持的，因此可能需要使用其他的方式去实现。
 *
 * @author zhongjun
 * @date 2023/2/1 19:29
 */
@Inherited
@Target({PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
@Component
@Constraint(validatedBy = {MultipartFilesValidator.class, MultipartFileValidator.class})
public @interface MultipartFileVerify {

    String message() default "文件校验失败";

    /**
     * 文件类型限制
     */
    FileType[] value() default {};

    /**
     * 不允许上传的文件类型，不指定则不作限制
     */
    FileType[] notAllow() default {};

    /**
     * 文件大小限制，小于 0 表示不作限制；单位：千字节（KB）
     */
    long maxSize() default -1L;
}