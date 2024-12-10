# 基于springboot的文件上传类型检验工具类

## 使用方法
### 1. 添加依赖
```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-validation</artifactId>
   </dependency>
```
```xml
   <dependency>
       <groupId>com.zhongjun.validator</groupId>
       <artifactId>multipartfiles-type-validator-component</artifactId>
   </dependency>
```
### 2. 代码示例
```java
    @Slf4j
    @RestController
    @RequestMapping(
            value = {"/test"},
            produces = "application/json;charset=UTF-8")
    @RequiredArgsConstructor
    @Validated // 开启参数校验
    public class MultipartFileVerifyTestController {
    
        @PostMapping("/testFileUpload")
        public String testFileUpload(@Valid @MultipartFileVerify(value = {FileType.XLS, FileType.XLSX}, message = "请上传XLS、XLSX类型文件") @RequestParam("file") MultipartFile multipartFile) {
            return "true";
        }
    }
```
### 3. 效果验证
```shell
  curl --location 'http://127.0.0.1:8080/test/testFileUpload' --form 'file=@"/opt/test/1.txt"'
```
```json
  {"code":400,"message":"非法参数错误: testFileUpload.arg0: 请上传XLS、XLSX类型文件","data":"","timestamp":1733824798662}
```
### *ps:具体配置可参考demo,如有问题可以联系zhongjunwk@163.com*
