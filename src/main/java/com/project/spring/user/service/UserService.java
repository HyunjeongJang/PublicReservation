package com.project.spring.user.service;

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

        // User user = userRepository.find(oAuthUser.getProvider(), oAuthUser.getId());
        // if (user == null) {
        //     user = User.of(oAuthUser);
        //     userRepository.insertUser(user);
        // }
        // return user;
        if (userRepository.exist(oAuthUser.getProvider(), oAuthUser.getId())) {
            return userRepository.find(oAuthUser.getProvider(), oAuthUser.getId());
        } else {
            User user = User.of(oAuthUser);
            userRepository.insertUser(user);
            return user;
        }
    }

}
