package com.project.spring.facility.repository;

import com.project.spring.common.SearchDto;
import com.project.spring.facility.dto.GovDataDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public interface PhysicalRepository {

    int PhysicalDB(SqlSession sqlSession, List<Map<String, String>> list);

    List<GovDataDTO> findAll(SqlSession sqlSession, SearchDto params);

    int count(SqlSession sqlSession, SearchDto params);
}
