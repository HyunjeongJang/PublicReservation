package com.project.spring.client.oauth.dto.kakao;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.spring.client.oauth.dto.OAuthUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor  // 모든 인스턴스 변수를 받는 생성자
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoOAuthAttribute {
	private long id;
	private KakaoOAuthProperties properties;
	private KakaoOAuthAccount kakaoAccount;

	public OAuthUser toOAuth2User() {
		return new OAuthUser("KAKAO", id, properties.getNickname(), kakaoAccount.getEmail(), properties.getProfileImage());
	}
}

