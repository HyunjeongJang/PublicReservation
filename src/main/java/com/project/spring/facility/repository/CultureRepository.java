package com.project.spring.facility.repository;

import com.project.spring.facility.dto.GovDataDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CultureRepository {
    void insertInfo(GovDataDTO govDataDTO);

    List<GovDataDTO> cultureList();

}

