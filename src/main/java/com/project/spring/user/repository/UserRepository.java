package com.project.spring.user.repository;

import java.util.HashMap;
import java.util.Map;

import com.project.spring.client.oauth.dto.naver.NaverOauthAttribute;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.project.spring.user.entity.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

	private final SqlSessionTemplate sqlSession;

	public int insertUser(User user) {
		return sqlSession.insert("userMapper.insert", user);
	}

	public boolean exist(String provider, long providerId) {
		Map<String, Object> params = new HashMap<>();
		params.put("provider", provider);
		params.put("providerId", providerId);
		return sqlSession.selectOne("userMapper.select", params) != null;
	}

	public User find(String provider, long providerId) {
		Map<String, Object> params = new HashMap<>();
		params.put("provider", provider);
		params.put("providerId", providerId);
		return sqlSession.selectOne("userMapper.select", params);
	}

	public int insertNaverUser(NaverOauthAttribute naverOauthAttribute) {
		return  sqlSession.insert("userMapper.naverInsert",naverOauthAttribute);
	}


}
