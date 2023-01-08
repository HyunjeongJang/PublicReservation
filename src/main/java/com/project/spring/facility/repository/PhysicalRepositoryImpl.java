package com.project.spring.facility.repository;
import com.project.spring.common.SearchDto;
import com.project.spring.facility.dto.GovDataDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PhysicalRepositoryImpl implements PhysicalRepository{
    @Override
    public int PhysicalDB(SqlSession sqlSession, List<Map<String, String>> list) {
        int result = 0;
            sqlSession.delete("physicalMapper.deleteDb");
        System.out.println("리스트 사이즈"+list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
            sqlSession.insert("physicalMapper.PhysicalDB",list.get(i));
            result++;
        }
        return result;
    }

    @Override
    public List<GovDataDTO> findAll(SqlSession sqlSession, SearchDto params) {
        RowBounds rowBounds = new RowBounds(params.getPagination().getLimitStart(),params.getRecordSize());

        return sqlSession.selectList("physicalMapper.PhysicalList",null,rowBounds);
    }

    @Override
    public int count(SqlSession sqlSession, SearchDto params) {
        return sqlSession.selectOne("physicalMapper.count",params) ;
    }
}
