package com.project.spring.user.repository;

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

}
