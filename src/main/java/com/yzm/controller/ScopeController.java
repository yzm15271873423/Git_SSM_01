package com.yzm.controller;

import com.mysql.cj.Session;
import com.yzm.pojo.User;
import com.yzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/testScope2.do")
    public String testScope2(Model model){
        List<User> users = userService.findAllUser();
        System.out.println(users);
        model.addAttribute("message","requestMessage");
        model.addAttribute("user",users);

        return "redirect:/scope.jsp";
    }

    @RequestMapping("/testScope3.do")
    public ModelAndView testScope3(){
        ModelAndView mv = new ModelAndView();
        Map<String, Object> model = mv.getModel();
        List<User> users = userService.findAllUser();

        model.put("message","requestMessage");
        model.put("user",users);

        //mv.setViewName("forward:/scope.jsp");
        mv.setViewName("redirect:/scope.jsp");
        return mv;
    }

}
