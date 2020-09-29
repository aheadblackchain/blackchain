package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author solfeng
 * @date 2020/9/28 20:01
 */
@Entity
@Table(name = "tab_curriculum_imginfo")
public class CurriculumImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long iid;

    private String img;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "create_time")
    private Date createTime;

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
