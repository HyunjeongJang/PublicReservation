package com.project.spring.user.entity;

import com.project.spring.client.oauth.dto.OAuthUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private long userNo;
	private String provider;
	private String providerId;
	private String username;
	private String email;
	private String profileImage;
	private String address;
	private String interest;
	private String latestSearch;

	public static User of(OAuthUser oAuthUser) {
		return User.builder()
			.provider(oAuthUser.getProvider())
			.providerId(String.valueOf(oAuthUser.getId()))
			.username(oAuthUser.getNickname())
			.email(oAuthUser.getEmail())
			.profileImage(oAuthUser.getProfileImage())
			.build();
	}

}
