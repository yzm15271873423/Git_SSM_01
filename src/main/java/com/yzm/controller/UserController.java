package com.yzm.controller;

import com.yzm.pojo.User;
import com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 17:00
 * @Description: com.yzm.controller
 * @version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public ModelAndView testLogin(String uname, String password){
        System.out.println("login.do ......");
        ModelAndView mv = new ModelAndView();
        Map<String, Object> model = mv.getModel();
        model.put("msg","脏话，你好");

        //设计一个异常
        //int i =1/0;

        User user=userService.findUser(uname,password);
        if(null!=user){
            mv.setViewName("/success.jsp");
        }else {
            mv.setViewName("/fail.jsp");
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping("/findAllUser.do")
    public List<User> testFindAllUser(){
        return userService.findAllUser();
    }


}
