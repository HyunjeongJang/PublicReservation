package com.project.spring.facility.repository;

import java.util.ArrayList;
import java.util.List;

import com.project.spring.common.PageInfo;
import com.project.spring.common.Pagination;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.project.spring.facility.entity.CultureFacility;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CultureRepositoryImpl implements CultureRepository {

	private final SqlSessionTemplate sqlSession;


	private final Pagination pagination;


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




	@Override
	public int selectListCount() {
		return sqlSession.selectOne("cultureMapper.selectListCount");
	}

	@Override
	public ArrayList<CultureFacility> selectList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1)*pi.getBoardLimit();
		int limit = pi.getBoardLimit();

		RowBounds rowBounds = new RowBounds(offset,limit);

		return (ArrayList) sqlSession.selectList("cultureMapper.selectList", null ,rowBounds);
	}
















}
