package com.project.spring.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    /**
     * 회원 로그인페이지로 이동
     */
    @GetMapping("login.me")
    public String login() {
        return "user/loginPage";
    }

}
