package com.wzh.spring.controller;

import com.wzh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Controller("controller")
@Controller
public class UserController {
    @Autowired
            @Qualifier("service")
    UserService userService;


    public void saveUser(){
        userService.saveUser();
    }
}
