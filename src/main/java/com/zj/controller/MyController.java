package com.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(path = "/test")
    //返回String的时候会当做视图解析(推荐使用)
    public String test()
    {
        return "success.jsp";
    }

    /**
     * 如何返回json
     * @return
     */
    @RequestMapping(path = "/hello")
    @ResponseBody
    public String hello()
    {
        return "success!";
    }

    /**
     * 模拟后端返回对象到视图展示，mvc支持较好，返回类型为String时也可以达到效果
     * 返回的对象在requestScope域中
     * @return
     */
    @RequestMapping(path = "/data")
    public ModelAndView data()
    {
        System.out.println("in-data");
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","Jon");
        mv.addObject("age","15");
        mv.addObject("address","USA");
        //设置返回视图
        mv.setViewName("data.jsp");
        return mv;
    }

    /**
     * 直接转发，这里没走视图解析器的拼接路径
     * @return
     */
    @RequestMapping(path = "/trans")
    public String forward()
    {
        return "forward:/WEB-INF/jsp/success.jsp";
    }

    /**
     * 导向客户端重新发送的servlet地址
     * @return
     */
    @RequestMapping(path = "/re-send")
    public String redirect()
    {
        return "redirect:/hello";
    }
}
