package com.project.spring.facility.service;

import com.project.spring.facility.dto.CultureFacilityBoardRequest;
import com.project.spring.facility.dto.CultureFacilityBoardResponse;
import com.project.spring.facility.entity.CultureFacility;

import java.util.List;

public interface CultureService {


    int retrieveAndSave();

    public int selectListCount();

    public CultureFacilityBoardResponse selectList(CultureFacilityBoardRequest request);


    public CultureFacility cultureDetail(String svcId);


    public List<CultureFacility> recommendCultureList();


}
