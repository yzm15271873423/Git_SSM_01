package com.yzm.controller;

import com.mysql.cj.Session;
import com.yzm.pojo.User;
import com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yzm
 * @Date: 2021/5/19 - 05 - 19 - 21:39
 * @Description: com.yzm.controller
 * @version: 1.0
 */
@Controller
public class ScopeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/testScope.do")
    public String testScope(HttpServletRequest req, HttpSession session){
        List<User> users = userService.findAllUser();
        System.out.println(users);
        req.setAttribute("message","requestMessage");
        req.setAttribute("user",users);

        session.setAttribute("message","sessionMessage");
        session.setAttribute("user",users);

        ServletContext application = req.getServletContext();
        application.setAttribute("message","applicationMessage");
        application.setAttribute("user",users);
        return "/scope.jsp";
    }





}
