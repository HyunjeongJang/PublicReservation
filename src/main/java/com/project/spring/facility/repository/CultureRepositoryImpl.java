package com.project.spring.facility.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.spring.facility.dto.GovDataDTO;

@Repository
public class CultureRepositoryImpl implements CultureRepository {

	@Override
	public void insertInfo(GovDataDTO govDataDTO) {
		
	}

	@Override
	public List<GovDataDTO> cultureList() {
		return null;
	}
}
