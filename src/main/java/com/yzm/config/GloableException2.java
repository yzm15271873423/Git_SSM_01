package com.yzm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 10:21
 * @Description: com.yzm.config
 * @version: 1.0
 */

//@Configuration
public class GloableException2 {
   /* @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties pop = new Properties();
        pop.put("java.lang.ArithmeticException","error1.jsp");
        pop.put("java.lang.NullPointerException","error2.jsp");
        resolver.setExceptionMappings(pop);
        return resolver;

    }*/
}
