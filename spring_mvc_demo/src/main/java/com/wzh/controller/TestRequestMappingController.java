package com.wzh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
/**
 *1在类上也可以使用注解 在调用方法时会将类上的字符串和方法上的字符串拼接后当作逻辑视图返回
 *相当于给下面的路径都加上了一个上级目录
 *比如下面的类注解若存在 访问hello 逻辑视图为 test/hello/ hello在test目录下
 *表示浏览器地址栏输入xx/test/hello才能访问到对应的页面
 *这样做的意义在于 当由多个方法路径一致时 比如都叫delete 无法确定执行哪一个方法
 *这时就可以根据操作对象设置一个上级目录区分这两个方法
 *@RequestMapping("/test")
 *2value值是String型的数组 可以设置多个 这些路径都能访问对应方法
 * 3RequestMapping注解的属性method可以设置请求方式 也是数组类型 可以设置多个
 * RequestMethod型数组 请求方式若和注解的允许方式不同 就会报错
 * 也可根据请求方式使用注解
 *     @GetMapping
 *     @PostMapping
 *     @DeleteMapping
 *     @PutMapping
 * 4 param属性
 * 设置浏览器请求的请求参数必须满足的要求
 *  param 表示参数中必须携带param参数
 *  !param 表示参数中不能携带param参数
 *  param=value 表示参数中必须携带param参数且值为value
 *  param!=value 表示参数中要么不携带param参数 要么携带且值不为value
 *  参数不匹配访问会报错
 *  5 headers属性
 *  通过请求的请求头信息匹配请求,即浏览器发送的请求的请求头信息必须满足headers属性的设置
 *  不匹配就报错 用法和param类似
 *  6SpringMVC支持ant风格的访问路径 在@RequestMapping中可以设置特殊字符
 *  ?表示一个任意的字符 有些特殊符号不可以 比如 ? /等
 *  *表示零个或多个任意字符 也不能包括 ? /
 *  **表示任意层数的目录 可以匹配/ 使用方式只能将 ** 写到 //之间 不能有其他字符
 *  7@RequestMapping 中的占位符
 *  传统写法: /deleteUser?id=1
 *  rest: /user/delete/1 将参数写进路径中
 *  @RequestMapping("test/rest/{username}/{id}") 通过注解设置占位符 表示参数
 *  public String testRest(@PathVariable("username") String username,@PathVariable("id") Integer id)
 *  在方法头用注解获取路径中的参数为方法中的参数赋值
 */
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello", "hey", "hi"},
            method = {RequestMethod.GET,RequestMethod.POST}
//            params = {"username"}
//            headers = {"referer"}
    )
    public String hello() {
        return "success";
    }

    @RequestMapping("a?a/test/ant")
    public String testAnt() {
        return "success";
    }

    /**
     * {key}占位符 表示这里是传入的参数 并非真实的路径
     * 使用注解将传入的参数赋值给方法的参数
     */
    @RequestMapping("test/rest/{username}/{id}")
    public String testRest(@PathVariable("username") String username,@PathVariable("id") Integer id) {
        System.out.println("username:"+username);
        System.out.println("id:"+id);
        return "success";
    }
}
