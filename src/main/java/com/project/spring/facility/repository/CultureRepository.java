package com.project.spring.facility.repository;

import com.project.spring.common.PageInfo;
import com.project.spring.facility.dto.SearchRequest;
import com.project.spring.facility.dto.SearchResponse;
import com.project.spring.facility.entity.CultureFacility;

import com.project.spring.facility.entity.SearchType;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;


public interface CultureRepository {



    void truncate();

    void batchInsert(List<CultureFacility> cultures);

    List<CultureFacility> selectCulturelist() throws Exception;


    int selectListCount();

    ArrayList<CultureFacility> selectList(PageInfo pi);









}

