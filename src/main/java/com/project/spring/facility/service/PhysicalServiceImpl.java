package com.project.spring.facility.service;


import com.project.spring.facility.repository.PhysicalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PhysicalServiceImpl implements PhysicalService{

    private final SqlSession sqlSession;

    private final PhysicalRepository physicalRepository;


    @Override
    public int PhysicalDB(List<Map<String, String>> list) {
        return physicalRepository.PhysicalDB(sqlSession,list);
    }
}
