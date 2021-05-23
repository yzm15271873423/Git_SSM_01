package com.yzm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 9:52
 * @Description: com.yzm.controller
 * @version: 1.0
 */
@Controller
public class ControllerDemo1 {

    @RequestMapping("/test1.action")
    public String test1(){
        int i=1/0;
        return "success.jsp";
    }

    @RequestMapping("/test2.action")
    public String test2(){
        String s=null;
        System.out.println(s.getBytes());
        return "success.jsp";
    }

    /*@ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error1.jsp");
        return mv;
    }
*/
}
