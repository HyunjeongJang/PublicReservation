package com.project.spring.facility.dto;

import com.project.spring.facility.entity.SearchType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchRequest {
    private int currentPage;
    private SearchType searchType;
    private String contents;
}
