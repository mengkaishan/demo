package com.hushangjie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "view/index";
    }
    @RequestMapping("/view")
    public String view() {
        return "view";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(HttpServletResponse response){
        response.setHeader("refresh ","3"    );
        System.out.println("nihao");
        Random random=new Random();
        Integer s=random.nextInt(10);
        return s+"";
    }
}