package com.project.spring.facility.repository;

import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.entity.CultureFacility;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface CultureRepository {
//    void insertInfo(GovDataDTO govDataDTO);
//
//    List<GovDataDTO> cultureList();

    void truncate();

    void batchInsert(List<CultureFacility> cultures);

    public List<CultureFacility> selectCulturelist() throws Exception;



}

