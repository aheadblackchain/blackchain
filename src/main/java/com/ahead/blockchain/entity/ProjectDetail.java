package com.ahead.blockchain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_project_detail")
public class ProjectDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;

    @Column(name = "project_id")
    private Long projectId;

    public ProjectDetail(){

    }

    public ProjectDetail(String detail, Long projectId){
        this.detail = detail;
        this.projectId = projectId;
    }

    public ProjectDetail(Long projectId){
        this.projectId = projectId;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getNewsId() {
        return projectId;
    }

    public void setNewsId(Long projectId) {
        this.projectId = projectId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}