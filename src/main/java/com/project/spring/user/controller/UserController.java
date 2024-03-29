package com.project.spring.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

//    // 회원 가입 & 로그인 페이지
//    @GetMapping("/user/signup")
//    public String signup() {
//        return "signup";
//    }

    // 회원 로그인 페이지 이동
    @GetMapping("login.me")
    public String login() {
        return "user/loginPage";
    }

//    @GetMapping("/user/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }

//    @GetMapping("user/kakao/callback")
//    public String kakaoLogin(String code) {
//        // authorizedCode: 카카오 서버로부터 받은 인가 코드
//        UserService.kakaoLogin(code);
//        return "redirect:/";
//    }
}
