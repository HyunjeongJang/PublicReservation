package com.project.spring.client.oauth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.project.spring.client.oauth.dto.kakao.KakaoOAuthAttribute;
import com.project.spring.client.oauth.dto.OAuthToken;
import com.project.spring.client.oauth.dto.OAuthUser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class KakaoOAuthClient implements OAuthClient {

	private final static String authBaseUrl = "https://kauth.kakao.com";
	private final static String apiBaseUrl = "https://kapi.kakao.com";

	private final RestTemplate restTemplate;

	/**
	 *   객체가 여러개 필요하지 않다. -> Singleton Pattern -> Bean 으로 만들기 -> Spring IoC & DI
	 *
	 *   Bean 으로 만들 수 있는 방법
	 *     1. @Bean
	 *     2. @Component
	 */

	@Override
	public String getAccessToken(String code) {
		// Key, Value 를 짝지어서 데이터를 저장하는 자료구조 -> Map
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "b29bee6395982488962042875b786bc3");
		body.add("redirect_uri", "http://localhost:8090/PublicReservation/login");
		body.add("code", code);

		try {
			OAuthToken response = restTemplate.postForObject(authBaseUrl + "/oauth/token", body, OAuthToken.class);
			if (response == null) {
				throw new RuntimeException();  // TODO : CustomException 만들어 보기
			}
			return response.getAccessToken();
		} catch (Exception ex) {
			log.info(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	@Override
	public OAuthUser getUserInfo(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + accessToken);
		HttpEntity<Void> entity = new HttpEntity<>(headers);

		try {
			KakaoOAuthAttribute response = restTemplate.postForObject(apiBaseUrl + "/v2/user/me", entity, KakaoOAuthAttribute.class);
			if (response == null) {
				throw new RuntimeException();
			}
			return response.toOAuth2User();
		} catch (Exception ex) {
			log.info(ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

}
