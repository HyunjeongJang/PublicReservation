package com.project.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j
public class MainController {


    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView mv){
        log.info("MainPage");
        mv.setViewName("index");
        mv.addObject("content", "이런 문제였다니");

        return mv;
    }
}