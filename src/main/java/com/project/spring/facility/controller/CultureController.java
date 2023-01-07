package com.project.spring.facility.controller;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.facility.dto.CultureFacilityBoardRequest;
import com.project.spring.facility.dto.CultureFacilityBoardResponse;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.service.CultureService;

import com.project.spring.facility.type.AcceptStatus;
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
import java.util.List;

@Controller
@RequiredArgsConstructor // final이 붙은 멤버변수만 만사용해서 생성자를 자동으로 만들어줌
@Log4j
public class CultureController {

    private final CultureService cultureService;
    private final SeoulApiClient seoulApiClient;


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


//    /**
//     * 문화시설 리스트 - 페이징
//     */
//    @RequestMapping("/selectCultureList")
//    public String selectCultureList(
//            @RequestParam(value = "cpage", defaultValue = "1") int currentPage,
//            Model model
//    ) throws Exception {
//        CultureFacilityBoardResponse resp = cultureService.selectList(currentPage);
//        model.addAttribute("selectCultureList", resp.getCultureFacilityList());
//        model.addAttribute("pi", resp.getPageInfo());
//        return "facility/cultureListPage";
//    }


    /**
     * 문화시설 리스트 - 페이징 + 검색
     */
    @RequestMapping("/selectCultureList")
    public String selectCultureList(
            @RequestParam(value = "cpage", defaultValue = "1") int currentPage,
            @RequestParam(value = "search", defaultValue = "") String search,
            @RequestParam(value = "accept", defaultValue = "") List<AcceptStatus> acceptStatusList,
            Model model
    ) throws Exception {
        // TODO : 여기까지 search 와 acceptStatusList를 가져오기
        System.out.println(search);
        System.out.println(acceptStatusList.toString());

        // 이 데이터를 가지고 쿼리문을 작성하면 된다. AcceptStatus.A.getKorName();
        CultureFacilityBoardRequest req = new CultureFacilityBoardRequest(currentPage, search, acceptStatusList);
        CultureFacilityBoardResponse resp = cultureService.selectList(req);

        model.addAttribute("selectCultureList", resp.getCultureFacilityList());
        model.addAttribute("pi", resp.getPageInfo());
        return "facility/cultureListPage";
    }



    /**
     * 문화시설 상세보기 & 예약
     */
    @RequestMapping("/cultureDetail")
    public String cultureDetail(@RequestParam("svcId") String svcId, Model model) {
        CultureFacility cultureFacility = cultureService.cultureDetail(svcId);
        model.addAttribute("cultureDetail", cultureFacility);

        return "facility/cultureDetailPage";
    }




    @RequestMapping("/recommendCultureList")
    public String recommendCultureList(Model model) {
        model.addAttribute("recommendCultureList", cultureService.recommendCultureList());
        return "common/content";
    }






}
