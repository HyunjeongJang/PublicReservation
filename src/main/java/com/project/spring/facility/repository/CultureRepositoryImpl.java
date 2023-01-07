package com.project.spring.facility.repository;

import java.util.List;

import com.project.spring.common.PageInfo;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.repository.filter.CultureFacilityFilter;

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

    @Override
    public int selectListCount() {
        return sqlSession.selectOne("cultureMapper.selectListCount");
    }


//    페이징처리
//    @Override
//    public List<CultureFacility> selectList(PageInfo pageInfo) {
//    RowBounds rowBounds = pageInfo.generateRowBounds();
//    return sqlSession.selectList("cultureMapper.selectList", null, rowBounds);
//}


    @Override
    public List<CultureFacility> selectList(PageInfo pageInfo, CultureFacilityFilter filter) {
        RowBounds rowBounds = pageInfo.generateRowBounds();
        return sqlSession.selectList("cultureMapper.selectList", filter, rowBounds);
    }

    public CultureFacility cultureDetail(String svcId) {
        return sqlSession.selectOne("cultureMapper.selectDetail", svcId);
    }

    @Override
    public List<CultureFacility> recommendCultureList() {
        return sqlSession.selectList("cultureMapper.recommendCultureList");
    }
}
