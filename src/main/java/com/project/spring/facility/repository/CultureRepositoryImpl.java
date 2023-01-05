package com.project.spring.facility.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.entity.CultureFacility;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CultureRepositoryImpl implements CultureRepository {

	private final SqlSessionTemplate sqlSession;


	@Override
	public void truncate() {
		sqlSession.delete("cultureMapper.deleteAll");
	}

	@Override
	public void batchInsert(List<CultureFacility> cultures) {
		sqlSession.insert("cultureMapper.batchInsert", cultures);

		// return cultures.stream()
		// 	.mapToInt(culture -> sqlSession.insert("cultureMapper.insert", culture))
		// 	.sum();
	}

	@Override
	public List<CultureFacility> selectCulturelist() throws Exception {
		return sqlSession.selectList("cultureMapper.selectCultureList");
	}




//	public ArrayList<CultureFacility> selectCultureList(SqlSession sqlSession, Map<String,Object> paramMap){
//
//		return (ArrayList) sqlSession.selectCultureList("cultureMapper.searchCultureList", paramMap);
//	}













}
