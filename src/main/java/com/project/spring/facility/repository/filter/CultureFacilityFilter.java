package com.project.spring.facility.repository.filter;

import com.project.spring.facility.dto.CultureFacilityBoardRequest;
import com.project.spring.facility.type.AcceptStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CultureFacilityFilter {
    private String search;
    private List<AcceptStatus> acceptStatusList;
    private String area;

    public static CultureFacilityFilter from(CultureFacilityBoardRequest req) {
        return new CultureFacilityFilter(req.getSearch(), req.getAcceptStatusList(), req.getArea());
    }
}
