package com.yzm.controller;

import com.yzm.pojo.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yzm
 * @Date: 2021/5/23 - 05 - 23 - 11:17
 * @Description: com.yzm.controller
 * @version: 1.0
 */

@Controller
public class DataFormatController {

    @ResponseBody
    @RequestMapping("dataformat.action")
    public Emp dataformat(@RequestBody Emp emp){
        System.out.println(emp);
        return emp;
    }
}
