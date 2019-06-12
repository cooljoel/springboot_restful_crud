package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootRestfulCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulCrudApplication.class, args);
    }

    public ViewResolver myViewReolver() {
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver {


        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
