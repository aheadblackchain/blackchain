package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/28 19:54
 */
@Entity
@Table(name = "tab_curriculum_detailinfo")

public class CurriculumDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String currTitle;

    @Column(name = "detail")
    private String currDatail;

    @Column(name = "address")
    private String currAddress;

    @Column(name = "cur_id")
    private Long curId;



    public CurriculumDetail() {
    }



    public CurriculumDetail(Long id, String currTitle, String currDatail, String currAddress, Long curId) {
        this.id = id;
        this.currTitle = currTitle;
        this.currDatail = currDatail;
        this.currAddress = currAddress;
        this.curId = curId;
    }

    public CurriculumDetail(String i, Long id) {

    }

    public CurriculumDetail(Long curId) {
        this.curId = curId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrTitle() {
        return currTitle;
    }

    public void setCurrTitle(String currTitle) {
        this.currTitle = currTitle;
    }

    public String getCurrDatail() {
        return currDatail;
    }

    public void setCurrDatail(String currDatail) {
        this.currDatail = currDatail;
    }

    public String getCurrAddress() {
        return currAddress;
    }

    public void setCurrAddress(String currAddress) {
        this.currAddress = currAddress;
    }

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }
}

