package com.project.spring.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupportController {

    @GetMapping("/support")
    public String supportPage(@RequestParam(value = "svcid") String svcid,
                              Model model){

        model.addAttribute("svcid",svcid);
        return "support/supportPage";
    }
}
