package com.project.spring.facility.dto;

import com.project.spring.common.PageInfo;
import com.project.spring.facility.entity.CultureFacility;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResponse {
    private List<CultureFacility> cultureList;
    private PageInfo pageInfo;

}
