package com.project.spring.facility.controller;

import com.project.spring.common.PhysicalInfoExplorer;
import com.project.spring.facility.service.PhysicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
// final 이 붙거나 NotNull 이 붙은 필드의 생성자를 자동 생성해주는 룸복 어노테이션
@Log4j
public class PhysicalController {

    private final PhysicalInfoExplorer physicalInfoExplorer;

    private final PhysicalService physicalService;


    @GetMapping("/selectPhysicalList")
    public String searchPhysicalInfo(Model model) throws ParserConfigurationException, SAXException, IOException {

//        log.info("체육시설 파싱 스타트 체크");
//
//        physicalInfoExplorer.update();
//
//        log.info("체육시설 파싱 정보 입력 끝");

        model.addAttribute("selectPhysicalList", physicalService.selectPhysicalList());


        return "facility/physicalListPage";
    }


}