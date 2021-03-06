package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tab_animation")
@Entity
public class Animation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "talents_video")
    private String talentsVideo;

    private String title;


    private String particulars;

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

    public String getTalentsVideo() {
        return talentsVideo;
    }

    public void setTalentsVideo(String talentsVideo) {
        this.talentsVideo = talentsVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
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
