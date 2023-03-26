package com.wzh.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author wzh
 * @date 2023年03月25日 16:46
 * Description:代替web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    //设置一个配置类代替Spring的配置文件 可以是多个类即多个配置文件
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    //设置一个配置类代替SpringMVC的配置文件 同样可以是多个类 代表多个配置文件
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    //设置前端控制器DispatcherServlet的url-pattern
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    //设置当前的过滤器
    protected Filter[] getServletFilters() {
        //创建编码过滤器
        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("utf-8");
        cef.setForceEncoding(true);
        //创建处理请求方式的过滤器
        HiddenHttpMethodFilter hhmf = new HiddenHttpMethodFilter();
        return new Filter[]{cef,hhmf};
    }
}
