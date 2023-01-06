package com.project.spring.facility.controller;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.common.PageInfo;
import com.project.spring.common.Pagination;
import com.project.spring.facility.dto.SearchRequest;
import com.project.spring.facility.dto.SearchResponse;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.entity.SearchType;
import com.project.spring.facility.repository.CultureRepository;
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








}
