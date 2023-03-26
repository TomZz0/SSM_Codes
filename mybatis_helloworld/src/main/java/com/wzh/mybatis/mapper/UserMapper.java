package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
     /**
     * 添加用户
     */
    void insertUser();
     /**
     * 修改用户
     */
    void updateUser();
     /**
     * 删除用户
     */
    void deleteUser();

    /**
     * 通过id查询User对象
     * @return User对象
     */
    User getUserById();

    /**
     * 获得所有用户信息
     * @return User的List
     */
    List<User> getUsers();
}
