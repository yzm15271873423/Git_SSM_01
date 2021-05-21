package com.yzm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: yzm
 * @Date: 2021/5/21 - 05 - 21 - 16:28
 * @Description: com.yzm.interceptor
 * @version: 1.0
 */
public class MyInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor preHandle2");

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor postHandle2");
        //控制数据，过滤脏话
        Map<String, Object> model = modelAndView.getModel();
        String msg = (String)model.get("msg");
        String newMsg = msg.replaceAll("脏话", "**");
        model.put("msg",newMsg);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor afterCompletion2");

        //打印异常信息
        //System.out.println(ex);
    }
}
