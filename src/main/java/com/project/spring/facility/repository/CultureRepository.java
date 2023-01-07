package com.project.spring.facility.repository;

import com.project.spring.common.PageInfo;
import com.project.spring.facility.entity.CultureFacility;

import java.util.ArrayList;
import java.util.List;


public interface CultureRepository {

    void truncate();

    void batchInsert(List<CultureFacility> cultures);

    List<CultureFacility> selectCulturelist() throws Exception;

    int selectListCount();

    ArrayList<CultureFacility> selectList(PageInfo pi);

    public CultureFacility cultureDetail(String svcId);


    List<CultureFacility> recommendCultureList();
}

