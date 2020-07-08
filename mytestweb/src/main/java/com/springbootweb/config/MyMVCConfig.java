//package com.springbootweb.config;
//
//
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcAutoConfigurationAdapter;
//
//@Configuration
//public class MyMVCConfig extends WebMvcAutoConfigurationAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//
//    }
//    public WebMvcAutoConfiguration webMvcAutoConfiguration(){
//        WebMvcAutoConfiguration adapter = new WebMvcAutoConfiguration(){
//
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry){
//                registry.addViewController("/").setViewName("login");
////                registry.addViewController("index.html").setViewName("login");
//            }
//        };
//        return adapter;
//    }
//}
