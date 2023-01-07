package com.project.spring.facility.service;

import com.project.spring.common.PageInfo;
import com.project.spring.facility.dto.SearchRequest;
import com.project.spring.facility.dto.SearchResponse;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.repository.CultureRepository;

import java.util.ArrayList;
import java.util.List;

public interface CultureService {



    int retrieveAndSave();


//    public List<CultureFacility> selectCulturelist() throws Exception;



    public int selectListCount();

    public ArrayList<CultureFacility> selectList(PageInfo pi);


    public CultureFacility cultureDetail(String svcId);



}
