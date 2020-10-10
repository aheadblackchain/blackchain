package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author solfeng
 * @date 2020/9/25 10:36
 */
@Entity
@Table(name = "tab_curriculum")
public class Curriculum{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "cur_video")
    private String curVideo;

    @Transient
    private String curriculumImage;

    @Transient
    private List<String> detailList;

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

    public List<String> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<String> detailList) {
        this.detailList = detailList;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getCurVideo() {
        return curVideo;
    }

    public void setCurVideo(String curVideo) {
        this.curVideo = curVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
