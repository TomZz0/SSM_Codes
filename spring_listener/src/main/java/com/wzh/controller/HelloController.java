package com.wzh.controller;

import com.wzh.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author wzh
 * @date 2023年03月25日 20:24
 * Description:
 */
@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
}
