package com.project.spring.common;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponse<T> {

    private List<T> list = new ArrayList<>();
    private Pagination2 pagination2;

    public PagingResponse(List<T> list , Pagination2 pagination2){
        this.list = list;
        this.pagination2 = pagination2;
    }
}
