package com.ecommerce.config;

import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ServletConfig implements WebMvcConfigurer {

    public void configureViewResolver(ViewResolverRegistry registry){
        registry.jsp("/WEB-INF/views/",".jsp");
    }
}
