package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecialSQLMapper {
    //在模糊查询中不能使用#{} 因为在'%%'中间 占位符?不会被解析
    //方法1.使用${}
    //   2.使用字符串拼接函数 '%${}%' = concat('%',#{},'%')=concat('%','关键字','%')
    //   #{}会自带单引号
    //   3.使用"%"#{like}"%"      使用最多
    //   "%" 被解析为'%
    /**
     *  模糊查询查询操作
     * @param like
     * @return
     */
    List<User> getUserByLike(@Param("like") String like);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMoreUsers(@Param("ids") String ids);

    /**
     * 动态设置表名 查询user对象
     * @param tableName
     * @return
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 添加用户并获取自增的主键
     * @param user
     */
    void insertUser(User user);
}
