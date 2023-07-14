package com.tutor.tutorbe.base;

import lombok.Data;

import java.util.List;


@Data
public class PagedQueryResult<T> {
    private List<T> data;
    private Integer totalCount;
}
