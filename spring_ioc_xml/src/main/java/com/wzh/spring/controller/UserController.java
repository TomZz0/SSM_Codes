package com.wzh.spring.controller;

import com.wzh.spring.service.UserService;
import com.wzh.spring.service.impl.UserServiceImpl;

public class UserController {
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.saveUser();
    }
}
