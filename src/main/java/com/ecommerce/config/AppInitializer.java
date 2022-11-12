package com.ecommerce.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //root config
        AnnotationConfigWebApplicationContext rootConfig= new AnnotationConfigWebApplicationContext();
        rootConfig.register(DBConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));


        //servlet Config
        AnnotationConfigWebApplicationContext servletConfig= new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);

        // Multipart Config
        ServletRegistration.Dynamic servletRegistration= servletContext.addServlet("servlet", new DispatcherServlet(servletConfig));
        servletRegistration.setMultipartConfig(new MultipartConfigElement("/",2097152,41943054,50));


        //Multipart Filter Config
        FilterRegistration.Dynamic multipartFilet= servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilet.addMappingForUrlPatterns(null, true,"/*");

        //Load on startup
        servletRegistration.setLoadOnStartup(1);

        //mapping
        servletRegistration.addMapping("/");

    }
}
