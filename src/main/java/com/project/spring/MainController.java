package com.project.spring;

import com.project.spring.common.PhysicalInfoExplorer;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j
public class MainController {

    private final PhysicalInfoExplorer physicalInfoExplorer;

    public MainController(PhysicalInfoExplorer physicalInfoExplorer) {
        this.physicalInfoExplorer = physicalInfoExplorer;
    }

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView mv){
        log.info("MainPage");
        mv.setViewName("index");

        physicalInfoExplorer.update();

        return mv;
    }
}