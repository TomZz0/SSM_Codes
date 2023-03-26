package com.wzh.spring.dao.impl;

import com.wzh.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("保存用户成功");
    }
}
