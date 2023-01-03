package com.project.spring.client.oauth;

import com.project.spring.client.oauth.dto.OAuthUser;

public interface OAuthClient {
	String getAccessToken(String code);
	OAuthUser getUserInfo(String accessToken);
}
