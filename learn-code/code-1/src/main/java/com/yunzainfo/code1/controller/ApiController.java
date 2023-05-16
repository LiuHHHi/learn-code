package com.yunzainfo.code1.controller;

import com.yunzainfo.code1.entity.YzR;
import com.yunzainfo.code1.entity.json.JsonParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lemon
 * @date 2022/5/18 16:57
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    /**
     * 不带参数
     *
     * @return
     */
    @GetMapping("/get-1")
    public ResponseEntity<?> get1() {
        return YzR.ofOk("get1");
    }

    @GetMapping("/get-2")
    public ResponseEntity<?> get2(@RequestParam("name") String name,
                                  // 在参数中，必须使用 包装类接收数据
                                  @RequestParam("age") Integer age,
                                  @RequestParam("flag") Boolean flag,
                                  // 接收数组数据
                                  @RequestParam("books") List<String> books,
                                  // 注意 1. required = false 表示该参数可以不传递
                                  // 2. 写多个注解参数时，需要每个都写 key名字
                                  @RequestParam(name = "dept", required = false) String dept) {
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        result.put("flag", flag);
        result.put("books", books);
        result.put("dept", dept);
        return YzR.ofOk(result);
    }

    /**
     * 注意路径上的参数 使用花括号，注解用 PathVariable
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/get-3/{name}/{age}")
    public ResponseEntity<?> get3(@PathVariable("name") String name,
                                  @PathVariable(name = "age", required = false) Integer age) {
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        return YzR.ofOk(result);
    }

    @PostMapping("/post-1/form")
    public ResponseEntity<?> post1(@RequestParam("name") String name,
                                   @RequestParam(name = "age", required = false) Integer age) {
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        return YzR.ofOk(result);
    }

    @PostMapping("/post-2/x-www-form-urlencoded")
    public ResponseEntity<?> post2(@RequestParam("name") String name,
                                   @RequestParam(name = "age", required = false) Integer age) {
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", age);
        return YzR.ofOk(result);
    }

    @PostMapping("/post-3/json")
    public ResponseEntity<?> post3(@RequestBody JsonParam param) {
        return YzR.ofOk(param);
    }

    @PostMapping("/post-file")
    public ResponseEntity<?> post4(@RequestParam MultipartFile uploadFile) {
        String name = uploadFile.getName();
        String originalFilename = uploadFile.getOriginalFilename();
        String contentType = uploadFile.getContentType();
        long size = uploadFile.getSize();
        Map<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("originalFilename", originalFilename);
        result.put("contentType", contentType);
        result.put("size", size);
        return YzR.ofOk(result);
    }

    @GetMapping("/url/a/*/a")
    public ResponseEntity<?> url1() {
        return YzR.ofOk("url1");
    }

    @GetMapping("/url/b/**")
    public ResponseEntity<?> url2() {
        return YzR.ofOk("url2");
    }
}
