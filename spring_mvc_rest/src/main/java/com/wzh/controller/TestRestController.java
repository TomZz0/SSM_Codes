package com.wzh.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author wzh
 * @date 2023年03月23日 21:16
 * Description:
 * 查询所有用户信息: -->/user-->get方法
 * 查询id=1的用户信息: -->/user/1-->get方法
 * 添加用户信息: -->/user-->post方法
 * 修改用户信息: -->/user-->put方法
 * 删除用户信息: -->/user-->delete方法
 *
 * 浏览器只能发送get和post请求 若要发送put或delete请求 需要在web.xml文件中配置
 * HiddenHttpMethodFilter 配置了过滤器后 将表单方式设置为post 然后设置隐藏域
 * <input type="hidden" name="_method" value="put"> 在value中填入要发送请求的方式即可
 */
@Controller
public class TestRestController {
    /**
     * 查询所有用户
     * @return
     */
//    @GetMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    /**
     * 查询id为1的用户
     * @return
     */
//    @GetMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id")Integer id) {
        System.out.println("查询id="+id+"的用户信息");
        return "success";
    }
    /**
     * 添加用户信息
     * @return
     */
//    @PostMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("添加用户");
        return "success";
    }
    /**
     * 修改用户信息
     * @return
     */
//    @PutMapping("/user")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("修改用户");
        return "success";
    }
    /**
     * 删除用户信息
     * @return
     */
//    @DeleteMapping("/user/{id}")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")Integer id) {
        System.out.println("删除用户");
        return "success";
    }
}
