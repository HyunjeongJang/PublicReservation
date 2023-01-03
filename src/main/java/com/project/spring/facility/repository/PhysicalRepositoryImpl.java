package com.project.spring.facility.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PhysicalRepositoryImpl implements PhysicalRepository{
    @Override
    public int PhysicalDB(SqlSession sqlSession, List<Map<String, String>> list) {
        int result = 0;

        for(int i = 0; i<list.size(); i++){
            sqlSession.insert("physicalMapper.PhysicalDB",list.get(i));
            result++;
        }
        return result;
    }
}
