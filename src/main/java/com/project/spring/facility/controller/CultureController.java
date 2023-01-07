package com.project.spring.facility.controller;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.common.PageInfo;
import com.project.spring.common.Pagination;
import com.project.spring.facility.entity.CultureFacility;
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
import java.util.ArrayList;

@Controller
@RequiredArgsConstructor // final이 붙은 멤버변수만 만사용해서 생성자를 자동으로 만들어줌
@Log4j
public class CultureController {

    private final CultureService cultureService;
    private final SeoulApiClient seoulApiClient;

    private final Pagination pagination;


    /**
     * 문화시설 데이터 가져오기
     */
    @GetMapping("/searchCultureList")
    public void searchInfo(Model model) throws ParserConfigurationException, SAXException, IOException {

        log.info("문화시설 파싱 스타트 체크");
        int result = cultureService.retrieveAndSave();
        System.out.println(result);

        log.info("문화시설 파싱 정보 입력 끝");
    }


    /**
     * 문화시설 리스트 - 페이징
     */
    @RequestMapping("/selectCultureList")
    public String selectCulturelist(@RequestParam(value = "cpage", defaultValue = "1") int currentPage, Model model) throws Exception {

        int listCount = cultureService.selectListCount();

        int pageLimit = 10;
        int boardLimit = 12;
        PageInfo pi = pagination.getPageInfo(listCount, currentPage, pageLimit, boardLimit);

        ArrayList<CultureFacility> selectCultureList = cultureService.selectList(pi);

        model.addAttribute("selectCultureList", selectCultureList);
        model.addAttribute("pi", pi);

        return "facility/cultureListPage";
    }




    /**
     * 문화시설 리스트
     */
//    @RequestMapping("/selectCultureList")
//    public String selectCulturelist(
//            @RequestParam(value = "cpage", defaultValue = "1") int currentPage,
//            @RequestParam(value = "s_type", defaultValue = "TITLE") String type,
//            @RequestParam(value = "s_content", defaultValue = "") String sContent,
//            Model model) throws Exception {

//        SearchType sType = SearchType.valueOf(type.toUpperCase());
//        log.info("s_type : " + sType.name());
//        log.info("s_content : " + sContent);
//
//        SearchRequest req = new SearchRequest(currentPage, sType, sContent);
//        SearchResponse resp = cultureService.search(req);
//
//        model.addAttribute("cultureList", resp.getCultureList());
//        model.addAttribute("pi", resp.getPageInfo());
//        model.addAttribute("s_type", sType.name());
//        model.addAttribute("s_content", sContent);
//        return "facility/cultureListPage";
//    }


//    @RequestMapping("/cultureDetail")
//    public void cultureDetail(@RequestParam("svcId") String svcId, Model model) {
//
//        CultureFacility cultureFacility = cultureService.cultureDetail(svcId);
//
//        model.addAttribute("cultureDetail", cultureFacility);
//    }


    @RequestMapping("/cultureDetail")
    public String cultureDetail(@RequestParam("svcId") String svcId, Model model) {
        CultureFacility cultureFacility = cultureService.cultureDetail(svcId);
        model.addAttribute("cultureDetail", cultureFacility);

        return "facility/cultureDetailPage";
    }














}
