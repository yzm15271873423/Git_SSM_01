package com.yzm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 10:35
 * @Description: com.yzm.config
 * @version: 1.0
 */
@Configuration
public class GloableException3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        if(e instanceof NullPointerException){
            mv.setViewName("error2.jsp");
        }

        if(e instanceof ArithmeticException){
            mv.setViewName("error1.jsp");
        }
        return mv;
    }
}
