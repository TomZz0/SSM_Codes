package com.wzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    //请求路径为上下文路径 即/SpringMVC 表示输入xxx/SpringMVC
    //就返回index 根据设置 即为 xxx/SpringMVC/WEB-INF/templates/index.html
    public String portal(){
        //返回逻辑视图
        return "index";
    }
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
}
