package com.wzh.controller;

import com.google.gson.Gson;
import com.wzh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wzh
 * @date 2023年03月25日 10:32
 * Description:
 * 使用@RequestBody注解将请求体中的内容和控制器方法的形参进行绑定
 * 使用@RequestBody注解将json格式的请求参数转换成java对象
 * 1 导入jackson的依赖
 * 2 在springmvc的配置文件中设置<mvc:annatation-driven></mvc:annatation-driven>
 * 3 在处理请求的控制器方法的形参位置直接设置要转换成的java对象 前边加上@RequestBody注解
 *
 * @ResponseBody注解能将方法的返回值作为响应体相应到浏览器
 * 使用@ResponseBody注解响应浏览器json格式的数据
 * a>导入jackson依赖
 * b>在springmvc配置文件中设置<mvc:annatation-driven/>
 * c>将需要转换为json字符串的java对象直接作为控制器方法的返回值 使用注解标识方法
 */
@Controller
public class TestAjaxController {
    @RequestMapping(value = "/test/ajax",method = RequestMethod.POST)
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse resp) throws IOException {
        System.out.println(requestBody);
        System.out.println("id=" + id);
        String con = "hello ajax";
        Gson gson = new Gson();
        String s = gson.toJson(con);
        resp.getWriter().write(s);
    }
    @RequestMapping(value = "/test/RequestBody/json",method =RequestMethod.POST ,consumes = "application/json;charset=utf-8")
    public void testRequestBody(@RequestBody User user,HttpServletResponse resp) throws IOException {
        System.out.println(user);
        String con = "hello RequestBody";
//        一般我们要操作 json 中的数据的时候，需要 json 对象的格式。
//        一般我们要在客户端和服务器之间进行数据交换的时候，使用 json 字符串。
        Gson gson = new Gson();
        //转成Json串
        String s = gson.toJson(con);
        resp.getWriter().write(s);
    }
    @ResponseBody
    @RequestMapping("/test/ResponseBody/json")
    public User testResponseBody(Integer id){
        //也可以相应Map List集合 返回类型修改一下就行
        //List为JSON数组类型 其他为JSON对象
        User user = new User("","2022",23, '女');
        if (id==1) user.setUsername("桥本有菜");
        else if (id==2) user.setUsername("三上悠亚");
        else if (id==3) user.setUsername("桃乃木香奈");
        return user;
    }
}
