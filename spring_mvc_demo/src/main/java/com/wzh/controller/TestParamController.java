package com.wzh.controller;

import com.wzh.pojo.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 获取参数的方式
 * 1.通过servletAPI获取
 * 只需要在方法参数列表中设置HTTPServletRequest类型的参数就可以获取到对象
 * 在控制器方法中使用request
 * 2只需要在控制器方法的形参位置设置和传入参数同名的参数即可
 * 比如表单中有username 和 password 只需设置
 * public String testAPIp(String username,String password) 即可
 * 3 @RequestParam 将控制器方法的形参和页面提交的数据绑定
 * 中有三个属性 要绑定的参数名 是否必须传入 默认值 若设置必须传入且没传入 则报错
 * 若设置不必须传入且没传入 值为默认值或者null
 * value = "userName",required = false,defaultValue = "hello"
 * 4@RequestHeader:将请求头信息和控制器方法的形参绑定
 * 5@CookieValue:将Cookie数据和控制器方法的形参绑定
 * 6通过控制器方法的实体类类型的形参获取参数 只需要在形参列表设置目标实体类即可
 * 要保证从浏览器传来的参数的名字和实体类中属性的名字一致
 * 7乱码问题 tomcat8的版本中 在使用request和response时get方法都不会乱码 而post会乱码
 * 解决方法 设置过滤器过滤请求 设置完编码后再交由servlet
 * 在web.xml中配置即可
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String testAPI(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session 会生成一个cookie
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名:" + username + "密码:" + password);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(username);
        return "success";
    }

    @RequestMapping("/param")
    public String testAPIp //可以设置匹配哪个提交过来的值 可以设置默认值 当不必须传入时使用默认值
    (@RequestParam(value = "userName", required = false, defaultValue = "hello") String username, String password
            , @RequestHeader("referer") String referer, @CookieValue("JSESSIONID") String jsessionid) {
        System.out.println("referer:" + referer);
        System.out.println("cookie:" + jsessionid);
        System.out.println(username + ":" + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    //只需要设置一个实体类形参即可 要保证此类中的属性和从页面传来的值的name一致
    public String testAPIPojo(Player player) {
        System.out.println(player);
        return "success";
    }


}
