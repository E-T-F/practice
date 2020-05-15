package com.etf.adapter.dto;

import com.etf.annotation.MyAnnotation;
import com.etf.annotation.MyColumn;
import com.etf.dto.BaseRequestDto;
import lombok.Data;

@Data
@MyAnnotation("etf-table")
public class SearchRequestDto extends BaseRequestDto {


    private static final long serialVersionUID = 6243006857239504126L;

    @MyColumn(type = MyColumn.Type.Q)
    private String name;

    @MyColumn(type = MyColumn.Type.Q)
    private Long id;

    @MyColumn(type = MyColumn.Type.IN)
    private Integer[] type;

    @MyColumn(type = MyColumn.Type.IN)
    private Object[] userId;

    @MyColumn(type = MyColumn.Type.F)
    private Long[] status;

    @MyColumn(type = MyColumn.Type.F)
    private Long[] score;

    @MyColumn(type = MyColumn.Type.F)
    private Long[] time;

}
