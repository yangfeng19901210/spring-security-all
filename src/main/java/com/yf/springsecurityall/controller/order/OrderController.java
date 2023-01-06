package com.yf.springsecurityall.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring-security-all
 * @package: com.yf.springsecurityall.controller.order
 * @className: OrderController
 * @author: yangfeng
 * @description: TODO
 * @date: 2023/1/4 13:53
 * @version: 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @RequestMapping("/list")
    public String list(){
        return "order/list";
    }

    @RequestMapping("/add")
    public String add(){
        return "order/add";
    }

    @RequestMapping("/view")
    public String view(){
        return "order/detail";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "order/edit";
    }

    @RequestMapping("/delete")
    public String delete(){
        return "order/delete";
    }
}
