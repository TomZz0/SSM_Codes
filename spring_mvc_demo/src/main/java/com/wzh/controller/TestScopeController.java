package com.wzh.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.util.Map;

/**
 * 向域对象中共享数据
 * 1通过ModelAndView共享数据 方法返回值要是ModelAndView类
 * 2通过Model共享数据 在方法参数中设置Model 在方法内部使用 添加数据即可
 * 3通过ModelMap共享数据 在方法参数中设置ModelMap 在方法内部使用 添加数据即可
 * 4通过map共享数据
 * 5 Model/ModelMap/Map在底层中都是通过BindingAwareModelMap实例化
 * BindingAwareModelMap的父类 继承了ModelMap 且实现了Model接口
 * 而ModelMap继承了LinkedHashMap LinkedHashMap实现了map
 */
@Controller
public class TestScopeController {
    /**
     * ModelAndView有Model和View的功能
     * Model用于向域中共享数据
     * View用户设置视图 实现页面跳转
     *
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //获取对象
        ModelAndView mav = new ModelAndView();
        //向域中保存数据
        mav.addObject("testScope", "hello,modelAndView");
        //设置逻辑视图 实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    /**
     * 通过Model方式共享数据
     * 在形参设置Model参数 使用即可
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        //向域中添加数据
        model.addAttribute("testModel", "hello,Model");
        return "success";
    }

    /**
     * 通过ModelMap向域中设置数据
     */
    @RequestMapping("/testModelMap")
    public String testModel(ModelMap modelMap) {
        //向域中添加数据
        modelMap.addAttribute("testModelMap", "hello,ModelMap");
        return "success";
    }

    /**
     * 通过map向域中放置数据
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testMap", "hello Map");
        return "success";
    }
    /**
     * 向session中设置数据
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSession", "hello Session");
        return "success";
    }
    /**
     * 向Application中设置数据
     */
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplication", "hello application");
        return "success";
    }
    /**
     * 创建thymeleaf的视图
     */
    @RequestMapping("/test/view/thymeleaf")
    public String testThymeleaf(){
        return "success";
    }
    /**
     * 创建转发视图
     */
    @RequestMapping("/test/view/forward")
    public String testInternalResourceView(){
        return "forward:/testModel";
    }
    /**
     * 创建重定向视图
     */
    @RequestMapping("/test/view/redirect")
    public String testRedirectView(){
        return "redirect:testModel";
    }
}
