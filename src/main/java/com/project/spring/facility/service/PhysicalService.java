package com.project.spring.facility.service;

import com.project.spring.facility.dto.GovDataDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PhysicalService {
    int PhysicalDB(List<Map<String, String>> list);

    public List<GovDataDTO> selectPhysicalList();
}
