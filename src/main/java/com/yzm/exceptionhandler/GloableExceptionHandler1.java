package com.yzm.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 10:05
 * @Description: com.yzm.exceptionhandler
 * @version: 1.0
 */

//@ControllerAdvice
public class GloableExceptionHandler1 {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public ModelAndView handleException(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error2.jsp");
        return mv;
    }

}
