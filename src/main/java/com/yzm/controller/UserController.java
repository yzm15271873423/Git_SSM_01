package com.yzm.controller;

import com.yzm.pojo.User;
import com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String testLogin(String uname,String password){
        String view ="";
        User user=userService.findUser(uname,password);
        if(null!=user){
            view ="/success.jsp";
        }else {
            view="/fail.jsp";
        }

        return view;
    }

}
