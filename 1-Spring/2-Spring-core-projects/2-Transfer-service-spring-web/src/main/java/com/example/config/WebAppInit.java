package com.example.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("onStartup");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(TransferServiceConfiguration.class);

        // Register and map the dispatcher servlet
        /*
        I'm doing this servlet registration.
        And one of the ready made servlet given by the Spring Framework to assist can be dispatcher servlet.
        And one good thing about this dispatcherservlet is this dispatcherservlet process,
        every incoming request using his spring beans.
         */
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(0);
        dispatcher.addMapping("/");

    }

}