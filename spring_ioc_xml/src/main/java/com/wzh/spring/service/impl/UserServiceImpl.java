package com.wzh.spring.service.impl;

import com.wzh.spring.dao.UserDao;
import com.wzh.spring.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }
}
