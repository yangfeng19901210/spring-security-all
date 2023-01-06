package com.yf.springsecurityall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.controller
 * @className: TestController
 * @author: yangfeng
 * @description: TODO
 * @date: 2023/1/4 11:18
 * @version: 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
