package com.project.spring.facility.repository;

import java.util.List;

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
	public void insertInfo(GovDataDTO govDataDTO) {
		
	}

	@Override
	public List<GovDataDTO> cultureList() {
		return null;
	}

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
}
