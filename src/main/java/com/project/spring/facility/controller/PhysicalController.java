package com.project.spring.facility.controller;

import com.project.spring.common.PhysicalInfoExplorer;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
@Log4j
public class PhysicalController {

    private final PhysicalInfoExplorer physicalInfoExplorer;

    public PhysicalController(PhysicalInfoExplorer physicalInfoExplorer) {
        this.physicalInfoExplorer = physicalInfoExplorer;
    }

    @GetMapping("/insertPhysicalList")
    public void searchPhysicalInfo(Model model) throws ParserConfigurationException, SAXException, IOException {

        log.info("체육시설 파싱 스타트 체크");

        physicalInfoExplorer.update();

        log.info("체육시설 파싱 정보 입력 끝");
    }


}