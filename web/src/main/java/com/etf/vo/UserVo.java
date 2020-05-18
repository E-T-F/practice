package com.etf.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangfei1@corp.netease.com
 * @date 2020/5/18 15:27
 */
@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -7454982864985008305L;

    private Long id;

    private String userName;

    private String email;

    private String nickName;

    private Integer status;

}
