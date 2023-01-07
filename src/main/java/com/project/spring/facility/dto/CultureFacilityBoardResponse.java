package com.project.spring.facility.dto;

import com.project.spring.common.PageInfo;
import com.project.spring.facility.entity.CultureFacility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CultureFacilityBoardResponse {
    private List<CultureFacility> cultureFacilityList;
    private PageInfo pageInfo;
}
