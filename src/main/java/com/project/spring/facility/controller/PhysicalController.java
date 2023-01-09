package com.project.spring.facility.controller;

import com.project.spring.common.PagingResponse;
import com.project.spring.common.PhysicalInfoExplorer;
import com.project.spring.common.SearchDto;
import com.project.spring.common.crawling.Test33;
import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.service.PhysicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
// final 이 붙거나 NotNull 이 붙은 필드의 생성자를 자동 생성해주는 룸복 어노테이션
@Log4j
public class PhysicalController {

    private final PhysicalInfoExplorer physicalInfoExplorer;

    private final PhysicalService physicalService;
    private final Test33 jsoupTest;


    @GetMapping("/down")
    public void dbDown(){
        log.info("체육시설 파싱 스타트 체크");

        physicalInfoExplorer.update();

        log.info("체육시설 파싱 정보 입력 끝");
    }


//    @GetMapping("/selectPhysicalList")
//    public String searchPhysicalInfo(
//            @ModelAttribute("params") final SearchDto params
//            // @ModelAttribute 전받은 객체를 자동으로 뷰(HTML)까지 전달할수 있음
//            ,Model model){
//        PagingResponse<GovDataDTO> response = physicalService.selectPhysicalList(params);
//        System.out.println("페이지"+params.getPage());
//        model.addAttribute("response",response);
//
//        return "facility/physicalListPage";
//    }

    @GetMapping("/selectPhysicalList")
    public String imageTest(Model model){
//        String image = jsoupTest.findImage();
//        model.addAttribute("image",image);
        return "ImageTest";
    }
}