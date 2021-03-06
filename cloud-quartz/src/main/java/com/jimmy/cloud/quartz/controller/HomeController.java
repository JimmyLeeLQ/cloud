package com.jimmy.cloud.quartz.controller;

import com.jimmy.cloud.quartz.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by chenqinglong on 2019/2/1 0001.
 */

@Controller
@RequestMapping(value = "/")
public class HomeController{

    @Autowired
    private JobService jobService;

    @RequestMapping(value="/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value="/home/page")
    @ResponseBody
    public ModelAndView goHome(){
        System.out.println("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        mode.setViewName("index");
        return mode;
    }
}
