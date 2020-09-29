package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author solfeng
 * @date 2020/9/28 19:54
 */
@Entity
@Table(name = "tab_curriculum_detailinfo")

public class CurriculumDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;

    private String datail;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "create_time")
    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "tab_curriculum_detailinfo_ibfk_1")
    private Curriculum curriculum;

    public CurriculumDetail(){
        super();
    }
    public CurriculumDetail(String datail){
        super();
        this.datail=datail;
    }
    public CurriculumDetail(String datail,Curriculum curriculum){
        super();
        this.datail=datail;
        this.curriculum=curriculum;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDatail() {
        return datail;
    }

    public void setDatail(String datail) {
        this.datail = datail;
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

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}

