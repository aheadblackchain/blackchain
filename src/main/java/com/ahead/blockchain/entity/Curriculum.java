package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author solfeng
 * @date 2020/9/25 10:36
 */
@Entity
@Table(name = "tab_curriculum_system")
public class Curriculum{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curriculum_image")
    private String curriculumImage;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Transient
    private List<String> detaillList;

    @Transient
    private List<String> imgList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurriculumImage() {
        return curriculumImage;
    }

    public void setCurriculumImage(String curriculumImage) {
        this.curriculumImage = curriculumImage;
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

    public List<String> getDetaillList() {
        return detaillList;
    }

    public void setDetaillList(List<String> detaillList) {
        this.detaillList = detaillList;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
