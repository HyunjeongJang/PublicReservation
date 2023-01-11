package com.project.spring.reservation.controller;

import com.project.spring.common.crawling.Test33;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Log4j
public class ReservationController {

    private final Test33 jsoupTest;

    @GetMapping("/reservationList")
    public String imageTest(Model model){
        String image = jsoupTest.findImage();
        model.addAttribute("image",image);
        return "ImageTest";
    }

}
