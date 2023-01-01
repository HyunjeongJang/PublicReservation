package com.project.spring.facility.service;

import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.repository.CultureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CultureServiceImpl implements CultureService {

    private CultureRepository cultureRepository;

    //생성자 주입
    @Autowired
    public CultureServiceImpl(CultureRepository cultureRepository) {
        this.cultureRepository = cultureRepository;
    }

    @Override
    public void insertInfo(GovDataDTO govDataDTO) {
        cultureRepository.insertInfo(govDataDTO);
    }

    @Override
    public List<GovDataDTO> cultureList() {
        return cultureRepository.cultureList();
    }

}
