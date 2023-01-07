package com.project.spring.facility.service;

import com.project.spring.common.PagingResponse;
import com.project.spring.common.SearchDto;
import com.project.spring.facility.dto.GovDataDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface PhysicalService {
    int PhysicalDB(List<Map<String, String>> list);

    PagingResponse<GovDataDTO> selectPhysicalList(SearchDto params);
}
