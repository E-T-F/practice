package com.etf.meta;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Auther: etf
 * @Date: 2020-05-15 16:33
 * @Description:
 */
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private LocalDateTime regTime;

    @Column(nullable = false)
    private Integer status;

    public User(String userName, String passWord, String email, String nickName, LocalDateTime regTime, Integer status) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
        this.status = status;
    }

    public User() {
    }

}