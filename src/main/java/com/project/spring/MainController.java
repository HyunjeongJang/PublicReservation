package com.project.spring;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j
public class MainController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        log.info("index controller start!!");

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("content", "경로좀 찾아주세요");

        return mav;
    }
}