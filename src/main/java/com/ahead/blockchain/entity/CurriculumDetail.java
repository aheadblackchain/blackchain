package com.ahead.blockchain.entity;

import javax.persistence.*;

/**
 * @author solfeng
 * @date 2020/9/28 19:54
 */
@Entity
@Table(name = "tab_curriculum_detail")

public class CurriculumDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detail")
    private String currDatail;

    @Column(name = "curriculum_id")
    private Long curId;

    public CurriculumDetail(){}

    public CurriculumDetail(Long curId){
        this.curId = curId;
    }

    public CurriculumDetail(String detail , Long curId){
        this.currDatail = detail;
        this.curId = curId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrDatail() {
        return currDatail;
    }

    public void setCurrDatail(String currDatail) {
        this.currDatail = currDatail;
    }

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }
}

