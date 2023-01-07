package com.project.spring.facility.dto;

import com.project.spring.facility.type.AcceptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CultureFacilityBoardRequest {

    private int currentPage;
    private String search;
    private List<AcceptStatus> acceptStatusList;

}
