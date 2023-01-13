package com.project.spring.user.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.project.spring.client.oauth.dto.naver.NaverLoginBO;
import com.project.spring.client.oauth.dto.naver.NaverOauthAttribute;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.project.spring.client.oauth.dto.naver.NaverLoginBO;
import com.project.spring.client.oauth.dto.naver.NaverOauthAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import com.project.spring.client.oauth.KakaoOAuthClient;
import com.project.spring.client.oauth.dto.OAuthUser;
import com.project.spring.user.entity.User;
import com.project.spring.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
public class LoginController {

    KakaoAPI kakaoApi = new KakaoAPI();


    private final NaverLoginBO naverLoginBO;
    private final NaverOauthAttribute naverOauthAttribute;
    private String apiResult = null;

    // 필드 주입방식
    private final UserService userService;

//    @Autowired
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }


    public LoginController(NaverLoginBO naverLoginBO, NaverOauthAttribute naverOauthAttribute, UserService userService) {
        this.naverLoginBO = naverLoginBO;
        this.naverOauthAttribute = naverOauthAttribute;
        this.userService = userService;
    }


    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        User loginUser = userService.login(code);

        System.out.println("login info : " + loginUser.getProfileImage());
        session.setAttribute("loginUser", loginUser);
        mav.setViewName("redirect:/");
        return mav;
    }

    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();

        session.removeAttribute("loginUser");
        mav.setViewName("redirect:/");
        return mav;
    }



    /**
     * 회원 로그인페이지로 이동
     */
    @RequestMapping(value = "/memberLogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String login(Model model, HttpSession session) {

        /* 네아로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        /* 인증요청문 확인 */
        System.out.println("네이버:" + naverAuthUrl);
        /* 객체 바인딩 */
        model.addAttribute("urlNaver", naverAuthUrl);

        /* 생성한 인증 URL을 View로 전달 */
        return "user/loginPage";
    }


    //네이버 로그인 성공시 callback호출 메소드
    @RequestMapping(value = "/callbackNaver.do", method = { RequestMethod.GET, RequestMethod.POST })
    public String callbackNaver(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
            throws Exception {
        System.out.println("로그인 성공 callbackNaver");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;

        jsonObj = (JSONObject) jsonParser.parse(apiResult);
        JSONObject response_obj = (JSONObject) jsonObj.get("response");
        // 프로필 조회
        String email = (String) response_obj.get("email");
        String name = (String) response_obj.get("name");
        String profileImage = (String) response_obj.get("profile_image");

        naverOauthAttribute.setEmail(email);
        naverOauthAttribute.setUserName(name);
        naverOauthAttribute.setProfileImage(profileImage);
        // 세션에 사용자 정보 등록
        // session.setAttribute("islogin_r", "Y");

        NaverOauthAttribute loginUser = userService.NaverLogin(naverOauthAttribute);


        /* 네이버 로그인 성공 페이지 View 호출 */
        return "redirect:/loginSuccess.do";
    }

    // 소셜 로그인 성공 페이지
    @RequestMapping("/loginSuccess.do")
    public String loginSuccess() {
        return "loginSuccess";
    }

}

















}
