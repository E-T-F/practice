package com.etf.vo;

import com.etf.annotation.MyColumn;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: etf
 * @Date: 2020-05-15 14:03
 * @Description:
 */
@Data
public class ReqeustVo implements Serializable {

    private static final long serialVersionUID = -7656127652073772852L;


    private String name;

    private Long id;

    private Integer[] type;

    private String userId;

    private Long[] status;

    private Long[] score;

    private Long[] time;
}
