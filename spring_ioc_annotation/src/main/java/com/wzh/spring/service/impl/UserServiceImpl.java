package com.wzh.spring.service.impl;

import com.wzh.spring.dao.UserDao;
import com.wzh.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;



    public void saveUser() {
        userDao.saveUser();
    }
}
