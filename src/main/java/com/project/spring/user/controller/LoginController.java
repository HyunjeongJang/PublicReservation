package com.project.spring.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    // 필드 주입방식
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value="/login")
    public ModelAndView login(@RequestParam("code") String code, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        User loginUser = userService.login(code);

        System.out.println("login info : " + loginUser.toString());
        session.setAttribute("loginUser", loginUser);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView();

        kakaoApi.kakaoLogout((String)session.getAttribute("accessToken"));
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        mav.setViewName("index");
        return mav;
    }

}
