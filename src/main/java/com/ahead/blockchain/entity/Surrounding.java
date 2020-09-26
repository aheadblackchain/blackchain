package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tab_surrounding")
@Entity
public class Surrounding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sur_img")
    private String surimg;

    @Column(name = "sur_belong")
    private String surbelong;

    @Column(name = "sur_describe")
    private String surdescribe;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurimg() {
        return surimg;
    }

    public void setSurimg(String surimg) {
        this.surimg = surimg;
    }

    public String getSurbelong() {
        return surbelong;
    }

    public void setSurbelong(String surbelong) {
        this.surbelong = surbelong;
    }

    public String getSurdescribe() {
        return surdescribe;
    }

    public void setSurdescribe(String surdescribe) {
        this.surdescribe = surdescribe;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}