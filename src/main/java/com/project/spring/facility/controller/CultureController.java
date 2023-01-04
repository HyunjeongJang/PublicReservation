package com.project.spring.facility.controller;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.client.seoulapi.dto.ReservationCultureDto;
import com.project.spring.facility.service.CultureService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j
public class CultureController {

    private final CultureService cultureService;
    private final SeoulApiClient seoulApiClient;

    //생성자 주입
    @RequestMapping("/showList")
    public String showlist() {
        return "facility/facilityListPage";
    }

    //검색시 데이터가 없으면 db에 추가하도록 처리
    @GetMapping("/searchCultureList")
    public void searchInfo(Model model) throws ParserConfigurationException, SAXException, IOException {

        log.info("파싱 스타트 체크");

        //파싱하여 리턴한 데이터 값들을 list에 담아주기 위해 사용
        // List<GovDataDTO> list = apiExplorer.parsingData("확인함");
        int result = cultureService.retrieveAndSave();
        System.out.println(result);

        // //List에 담겨있는 정보들을 db에 넣기 위해서 사용
        // for (GovDataDTO dataDTO : list) {
        //
        //     cultureService.insertInfo(dataDTO);
        //
        // }
        //
        // model.addAttribute("cultureList",cultureService.cultureList());

        log.info("파싱 정보 입력 끝");
    }


}
