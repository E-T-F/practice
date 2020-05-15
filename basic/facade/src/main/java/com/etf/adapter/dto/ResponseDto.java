package com.etf.adapter.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: etf
 * @Date: 2020-05-15 11:42
 * @Description:
 */
@Data
public class ResponseDto implements Serializable {

    private static final long serialVersionUID = -2090561682159859175L;


    private String result;
}
