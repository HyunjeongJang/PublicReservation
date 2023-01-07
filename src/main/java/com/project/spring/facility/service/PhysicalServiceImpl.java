package com.project.spring.facility.service;


import com.project.spring.common.Pagination2;
import com.project.spring.common.PagingResponse;
import com.project.spring.common.SearchDto;
import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.repository.PhysicalRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public PagingResponse<GovDataDTO> selectPhysicalList(SearchDto params) {
        int count = physicalRepository.count(sqlSession,params);
        if(count < 1){
            return new PagingResponse<>(Collections.emptyList(),null);
        }
        Pagination2 pagination2 = new Pagination2(count, params);
        params.setPagination2(pagination2);

        List<GovDataDTO> list = physicalRepository.findAll(sqlSession , params);
        return new PagingResponse<>(list, pagination2);
    }
}
