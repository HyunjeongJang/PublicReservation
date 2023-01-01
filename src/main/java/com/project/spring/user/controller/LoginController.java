package com.project.spring.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
public class LoginController {

    KakaoAPI kakaoApi = new KakaoAPI();

    @RequestMapping ("/user/login")
    public ModelAndView login(@RequestParam("code") String code , HttpSession session) {
        ModelAndView mv = new ModelAndView();
        // 1. 인증코드 요청 전달
        String access_token = kakaoApi.getAccessToken(code);
        // 2. 인증코드로 토큰 전달
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(access_token);
        System.out.println("login info : " + userInfo.toString());

        if(userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_token",access_token);
        }
        mv.addObject("userId", userInfo.get("email"));
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/user/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mv = new ModelAndView();

        kakaoApi.kakaoLogout((String)session.getAttribute("access_token"));
        session.removeAttribute("access_token");
        session.removeAttribute("userId");
        mv.setViewName("index");
        return mv;
    }







}
