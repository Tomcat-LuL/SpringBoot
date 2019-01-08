package com.example.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: LoginConfiguration
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2018/08/20下午 5:00
 * Version: 1.0
 */
@Configuration
public class LoginConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login","/logout",
                "/static/**");
        super.addInterceptors(registry);
        // 注册拦截器
//        LoginInterceptor loginInterceptor = new LoginInterceptor();
//        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
//        // 拦截路径
//        loginRegistry.addPathPatterns("/**");
//        // 排除路径
//        loginRegistry.excludePathPatterns("/");
//        loginRegistry.excludePathPatterns("/toLogin");
//        loginRegistry.excludePathPatterns("/login");
//        loginRegistry.excludePathPatterns("/logout");
//        // 排除资源请求
//        loginRegistry.excludePathPatterns("/static/*");
//
//        super.addInterceptors(registry);
    }
    /**
     * 修改springboot中默认的静态文件路径
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //addResourceHandler请求路径
    //addResourceLocations 在项目中的资源路径
    //setCacheControl 设置静态资源缓存时间
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
