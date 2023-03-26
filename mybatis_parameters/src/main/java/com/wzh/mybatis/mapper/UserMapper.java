package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 接口中方法的参数会跟随至相应的mapper.xml配置文件中 如何在配置文件中访问参数?
 * Mybatis获取参数可以使用${}和#{}两种方式
 * ${}本质是字符串拼接 #{}本质是占位符赋值
 * 1.
 * 若参数是单个字面量 则可使用任意内容获取参数 建议使用参数名获取
 * 比如传入参数为String name 获取可 '${name或任意字符串不能是数字}' 或#{name或任意}
 * 因为${}具有运算功能所以不能是数字
 * 2.
 * 若参数是多个字面量 则Mybatis会以map集合存储参数 有两种方式
 * 方式一: arg0,arg1...为键 参数为值
 * 方式二: param1,param2...为键 参数为值
 * 所以需要使用#{arg0或param1}或${arg1或param2}访问这些键获取参数值
 * 3.
 * 若参数是map集合
 * 在测试方法中创建一个map 将要查询的参数自定义名称和 value 放入map中
 * 然后方法中传入map 这样在UserMapper.xml中就可以使用自定义的名称获取参数来写sql语句
 * User checkLoginByMap(Map<String,Object>map);
 * 4.
 * 若参数是实体类 比如User user
 * 则在#{}中写入要获取的user对象的属性名即可获得对应属性
 * #{username} #{age}
 * 5.
 * 可以在mapper接口的参数上添加注解
 * 这时mybatis会将这些参数放置map中 以两种方式存储
 * 方式一 以@Param注解中的String 为key
 * 方式二 以param1,param2...存储
 * 比如下面这条方法 就会以username 和 password 为key来设置value
 * User checkUserByParam(@Param("username") String username, @Param("password") String password)
 */
public interface UserMapper {
    /**
     * 通过用户名获得用户信息
     * 常用于注册时判断用户是否已经存在等等
     * @param username 传入username
     * @return 返回User对象
     */
    User getUserByUsername(String username);

    /**
     * 输入用户名和密码 验证登录
     * @param name
     * @param password
     * @return
     */
    User checkLogin(String name,String password);


    /**
     * 传入map 自定义参数名
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object>map);

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 验证登录
     * 通过@Param注解设置参数在mybatis的map中的key 写sql语句时就可以使用自己设置的key来获取value
     * @param username
     * @param password
     * @return
     */
    User checkUserByParam(@Param("username") String username
            , @Param("password") String password);
}
