package com.project.spring.facility.service;

import com.project.spring.facility.entity.CultureFacility;

import java.util.List;

public interface CultureService {


    int retrieveAndSave();



    public List<CultureFacility> selectCulturelist() throws Exception;








}
