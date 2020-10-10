package com.ahead.blockchain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_project_img")
public class ProjectImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private String projectImg;

    @Column(name = "project_id")
    private Long projectId;

    public ProjectImg(){

    }

    public ProjectImg(Long projectId){
        this.projectId = projectId;
    }

    public ProjectImg(String projectImg, Long projectId){
        this.projectImg = projectImg;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}