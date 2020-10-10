package com.ahead.blockchain.entity;

import javax.persistence.*;

/**
 * @author solfeng
 * @date 2020/9/28 20:01
 */
@Entity
@Table(name = "tab_curriculum_img")
public class CurriculumImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private String curImg;

    @Column(name = "curriculum_id")
    private Long curId;

    public CurriculumImg(){}

    public CurriculumImg(Long curId){
        this.curId = curId;
    }

    public CurriculumImg(String curImg, Long curId){
        this.curImg = curImg;
        this.curId = curId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurImg() {
        return curImg;
    }

    public void setCurImg(String curImg) {
        this.curImg = curImg;
    }

    public Long getCurId() {
        return curId;
    }

    public void setCurId(Long curId) {
        this.curId = curId;
    }
}
