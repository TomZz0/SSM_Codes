package com.wzh.config;

import com.wzh.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author wzh
 * @date 2023年03月25日 16:48
 * Description:代替SpringMVC的配置文件
 * 扫描组件,视图解析器,默认的Servler,mvc的注解驱动,视图控制器,文件上传解析器,拦截器,
 * 异常解析器
 */
@EnableWebMvc//开启MVC的注解驱动
@Configuration//标识为配置类
@ComponentScan("com.wzh.controller")//扫描组件的注解
public class WebConfig implements WebMvcConfigurer {

    @Override
    //处理静态资源
    //默认Servlet处理静态资源 调用configurer的方法即可
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    //配置视图控制器
    public void addViewControllers(ViewControllerRegistry registry) {
        //当路径为/时默认进入index.html
        registry.addViewController("/").setViewName("index");
    }

    @Bean
    //配置文件上传
    //@Bean注解表示此方法的返回值作为一个bean被管理,bean的id为方法的方法名
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Override
    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {

        FirstInterceptor firstInterceptor = new FirstInterceptor();
        registry.addInterceptor(firstInterceptor).addPathPatterns("/**");
    }

    @Override
    //异常处理器
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        //创建Properties对象
        Properties prop = new Properties();
        //设置发生某个异常后要跳转的逻辑视图
        prop.setProperty("java.lang.ArithmeticException", "error");
        exceptionResolver.setExceptionMappings(prop);
        //设置共享请求域中的属性
        exceptionResolver.setExceptionAttribute("ex");
        //将设置好的异常添加到集合中
        resolvers.add(exceptionResolver);
    }


    @Bean
    //配置生成模板解析器
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext =
                ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver需要一个ServletContext作为构造参数，可通过WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(webApplicationContext.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean                                   //参数就是上边方法的返回值
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并未解析器注入模板引擎
    @Bean                           //参数就是上边方法的返回值
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
