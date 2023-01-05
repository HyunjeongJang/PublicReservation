package com.project.spring.facility.controller;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.common.Pagination;
import com.project.spring.facility.service.CultureService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Log4j
public class CultureController {

    private final CultureService cultureService;
    private final SeoulApiClient seoulApiClient;






    private Pagination pagination;


    @RequestMapping("/selectCultureList")
    public String selectCulturelist(
//            @RequestParam(value = "cpage", defaultValue = "1") int currentPage,
//            @RequestParam(value = "s_type", defaultValue = "TITLE") String type,
//            @RequestParam(value = "s_content", defaultValue = "") String sContent,
            Model model
    ) throws Exception {

//        SearchType sType = SearchType.valueOf(type.toUpperCase());
//        CultureSearchRequest req = new CultureSearchRequest(currentPage, sType, sContent);
//        CultureSearchResponse resp = cultureService.search(req);
//
//        model.addAttribute("list", resp.getCultureList());
//        model.addAttribute("pi", resp.getPageInfo());
//        model.addAttribute("s_type", sType.name());
//        model.addAttribute("s_content", sContent);

        model.addAttribute("selectCultureList", cultureService.selectCulturelist());

        return "facility/cultureListPage";
    }































    //검색시 데이터가 없으면 db에 추가하도록 처리
    @GetMapping("/searchCultureList")
    public void searchInfo(Model model) throws ParserConfigurationException, SAXException, IOException {

        log.info("문화시설 파싱 스타트 체크");

        int result = cultureService.retrieveAndSave();
        System.out.println(result);

        log.info("문화시설 파싱 정보 입력 끝");
    }
}
