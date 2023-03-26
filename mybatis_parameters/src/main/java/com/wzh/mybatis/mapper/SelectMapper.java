package com.wzh.mybatis.mapper;

import com.wzh.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
//    1)查询结果为多条数据时 不能使用实体类型作为方法的返回值
//    否则会抛出异常TooManyResultException
//
//    2)查询结果为单行数据时 可以使用实体类或list集合作为方法的返回值
//
//    3)如果没有现成的实体类接收查询结果
//     a>则可以使用Map<String,Object>来接收(单行数据)这时值为null的数据不会被保存到map中
//     b>多条无现成实体类接收的查询结果可以使用List<Map<String,Object>>来接收返回结果
//     c>多条无现成实体类接收的查询结果也可以使用大map,key=字段,value=每条查询结果
//       Map<Integer,Map<String,Object>>



    /**
     * 通过id 查询对象
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 获取所有User对象 返回List
     * @return
     */
    List<User> getUsers();

    /**
     * 查询记录总数
     * @return
     */
    Integer getCount();

    /**
     * 通过id查询用户 转成Map
     * 用于没有实体类型的查询结果 只能接收一行记录
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户 每个用户转成Map 放在List中
     * @return
     */
    List<Map<String,Object>> getUsersToMap_List();

    /**
     * 使用到注解@MapKey("id") 其值为大map中的key
     * 查询所有用户 每个用户转成Map 放在map中
     * @return
     */
    @MapKey("id")
    Map<Integer,Map<String,Object>> getUsersToMap_Map();
}
