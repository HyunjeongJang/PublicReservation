package com.project.spring.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageInfo {
    private int listCount;
    private int currentPage;
    private int pageLimit;
    private int boardLimit;
    private int maxPage;
    private int startPage;
    private int endPage;
}
