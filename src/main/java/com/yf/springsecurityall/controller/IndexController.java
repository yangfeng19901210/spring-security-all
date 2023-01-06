package com.yf.springsecurityall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.controller
 * @className: IndexController
 * @author: yangfeng
 * @description: TODO
 * @date: 2023/1/4 13:56
 * @version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
