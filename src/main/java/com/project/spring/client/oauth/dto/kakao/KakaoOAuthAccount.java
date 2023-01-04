package com.project.spring.client.oauth.dto.kakao;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor  // 모든 인스턴스 변수를 받는 생성자
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class KakaoOAuthAccount {
    private String email;
}
