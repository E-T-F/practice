package com.etf.dto;

import com.etf.annotation.MyColumn;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: etf
 * @Date: 2020-05-15 10:10
 * @Description:
 */
@Data
public class BaseRequestDto implements Serializable {

    private static final long serialVersionUID = -6406231753206074227L;

    private int limit;

    private long cursor;

    private MyColumn.Sort sortType;

    private String sortKey;
}
