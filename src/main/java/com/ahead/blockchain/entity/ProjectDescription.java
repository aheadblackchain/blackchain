package com.ahead.blockchain.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab_project_description")
public class ProjectDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_description")
    private String projectDetail;

    @Column(name = "project_id")
    private Long projectId;

    public ProjectDescription(){

    }

    public ProjectDescription(Long projectId){
        this.projectId = projectId;
    }

    public ProjectDescription(String projectDetail, Long projectId){
        this.projectDetail = projectDetail;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectDescription() {
        return projectDetail;
    }

    public void setProjectDescription(String projectDetail) {
        this.projectDetail = projectDetail;
    }

    public Long getNewsId() {
        return projectId;
    }

    public void setNewsId(Long projectId) {
        this.projectId = projectId;
    }
}