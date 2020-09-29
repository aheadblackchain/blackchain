package com.ahead.blockchain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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



    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Set<CurriculumDetail> curriculumDetails;
    public Curriculum() {
        super();
    }

    public Curriculum(String curriculumImage) {
        super();
        this.curriculumImage = curriculumImage;
        this.curriculumDetails = new HashSet<>();
    }

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
}
