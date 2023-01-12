package com.project.spring.user.service;

import com.project.spring.client.oauth.dto.naver.NaverOauthAttribute;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.client.oauth.KakaoOAuthClient;
import com.project.spring.client.oauth.dto.OAuthUser;
import com.project.spring.user.entity.User;
import com.project.spring.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final KakaoOAuthClient kakaoOAuthClient;
    private final UserRepository userRepository;

    public User login(String code) {
        String accessToken = kakaoOAuthClient.getAccessToken(code);
        OAuthUser oAuthUser = kakaoOAuthClient.getUserInfo(accessToken);
        User user = User.of(oAuthUser);
        // TODO : 지금 Insert 하는데, 이미 회원가입처리 되어있으면 Find(Select) 만 해서 반환만.
        int result = userRepository.insertUser(user);
        System.out.println(result);
        // TODO : 저장된걸 Select 해서 반환만.
        return user;
    }

    public NaverOauthAttribute NaverLogin(NaverOauthAttribute naverOauthAttribute) {
        userRepository.insertNaverUser(naverOauthAttribute);

        return naverOauthAttribute;

    }
}
