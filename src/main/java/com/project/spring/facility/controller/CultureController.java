package com.project.spring.facility.controller;

import com.google.gson.Gson;
import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.facility.dto.CultureFacilityBoardRequest;
import com.project.spring.facility.dto.CultureFacilityBoardResponse;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.dto.Reply;
import com.project.spring.facility.service.CultureService;

import com.project.spring.facility.service.ReplyService;
import com.project.spring.facility.type.AcceptStatus;
import com.project.spring.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


import java.util.List;

@Controller
@RequiredArgsConstructor // final이 붙은 멤버변수만 만사용해서 생성자를 자동으로 만들어줌
@Log4j
public class CultureController {

    private final CultureService cultureService;
    private final SeoulApiClient seoulApiClient;

    private final ReplyService replyService;


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
        // TODO : search 와 acceptStatusList를 가져오기
        System.out.println(search);
        System.out.println(acceptStatusList.toString());

        // 이 데이터를 가지고 쿼리문을 작성하면 됨 AcceptStatus.A.getKorName();
        CultureFacilityBoardRequest req = new CultureFacilityBoardRequest(currentPage, search, acceptStatusList);
        CultureFacilityBoardResponse resp = cultureService.selectList(req);

        model.addAttribute("selectCultureList", resp.getCultureFacilityList());
        model.addAttribute("pi", resp.getPageInfo());
        return "facility/cultureListPage";
    }






    /**
     * 문화시설 상세보기 & 예약페이지
     */
    @RequestMapping("/cultureDetail")
    public String cultureDetail(@RequestParam("svcId") String svcId, Model model) {
        CultureFacility cultureFacility = cultureService.cultureDetail(svcId);
        model.addAttribute("cultureDetail", cultureFacility);

        return "facility/cultureDetailPage";
    }


    /**
     * 추천서비스
     */
    @RequestMapping("/recommendCultureList")
    public String recommendCultureList(Model model) {
        model.addAttribute("recommendCultureList", cultureService.recommendCultureList());
        return "common/content";
    }


    /**
     * 댓글 불러오기
     */
    @RequestMapping("selectReply")
    @ResponseBody // 별도의 뷰페이지가 아니라 리턴값을 직접 지정 / json gson 타입의 반환을 지정해줄때
    public String selectReplyList(String svcId, Model model) {
        List<Reply> list = replyService.selectReplyList(svcId);
        Gson gson = new Gson();
        String result = gson.toJson(list);
        return result;
    }

    /**
     * 댓글 입력
     */
    @RequestMapping("insertReply")
    @ResponseBody // responseBody : 별도의 뷰페이지가 아니라 리턴값을 직접 지정해야 하는경우 사용.
    public String insertReply(Reply r, HttpSession session) {
        // 댓글목록 조회
        User m = (User) session.getAttribute("loginUser");
        if (m != null) {
            r.setReplyWriter(m.getUserNo() + "");
        }
        int result = replyService.insertReply(r);
        // gson으로 파싱
        if (result > 0) {
            return "1";
        } else {
            return "0";
        }
    }




}
