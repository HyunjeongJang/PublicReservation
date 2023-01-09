package com.project.spring.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SearchDto {

    private int page; // 현재 페이지 번호
    private int recordSize; // 페이지당 출력할 데이터 개수
    private int pageSize; // 화면 하단에 출력할 페이지 사이즈
    private String keyword; // 검색 키워드
    private String searchType; // 검색 유형
    private Pagination2 pagination2; // 페이지네이션 정보


    /**
     * 객체가 생성되는 시점에 기본값으로
     * 현재 페이지 번호 1로,
     * 페이지당 출력할 데이터 개수와 하단에 출력할 페이지 개수를 10으로 초기화
     */
    public SearchDto(){
        this.page = 1;
        this.recordSize = 12;
        this.pageSize = 10;
    }
}
